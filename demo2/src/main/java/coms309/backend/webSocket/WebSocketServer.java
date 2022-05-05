package coms309.backend.webSocket;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import coms309.backend.admin.Admin;
import coms309.backend.admin.AdminRepository;
import coms309.backend.doctor.DoctorRepository;
import coms309.backend.patient.Patient;
import coms309.backend.patient.PatientRepository;
import coms309.backend.user.User;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Vamsi Krishna Calpakkam
 *
 */
@Controller
@ServerEndpoint("/websocket/{username}")
@Component
public class WebSocketServer {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AdminRepository adminRepository;

    // Store all socket session and their corresponding username.
    private static Map < Session, String > sessionUsernameMap = new Hashtable < > ();
    private static Map < String, Session > usernameSessionMap = new Hashtable < > ();

    private final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username)
            throws IOException {
        logger.info("Entered into Open");

        sessionUsernameMap.put(session, username);
        usernameSessionMap.put(username, session);

        String message = "I got you login request";
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        // Handle new messages
//        logger.info("Entered into Message: Got Message:" + message);
//        String username = sessionUsernameMap.get(session);
//
//        if (message.startsWith("@")) // Direct message to a user using the format "@username <message>"
//        {
//            String destUsername = message.split(" ")[0].substring(1); // don't do this in your code!
//            sendMessageToPArticularUser(destUsername, "[DM] " + username + ": " + message);
//            sendMessageToPArticularUser(username, "[DM] " + username + ": " + message);
//        } else // Message to whole chat
//        {
//            broadcast(username + ": " + message);
//            System.out.println(username + ": " + message);
//        }

        JSONObject login = new JSONObject();
        login.put("email", message);

        broadcast(login.toJSONString());

//        Patient temp = patientRepository.findByEmail(message);
//        if (temp == null) {
//            broadcast("No email exists");
//        } else {
//            broadcast("Success!");
//        }
//        if (!password.equals(temp.getPassword())) {
//            output.put("status", 2); //status code for incorrect password
//            output.put("userInfo", null);
//            return output;
//        } else {
//            output.put("status", 3); //status code for correct login information
//            output.put("userInfo", temp);
//            return output;

    }

    @OnClose
    public void onClose(Session session) throws IOException {
        logger.info("Entered into Close");

        String username = sessionUsernameMap.get(session);
        sessionUsernameMap.remove(session);
        usernameSessionMap.remove(username);

        String message = username + " disconnected";
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
        logger.info("Entered into Error");
    }

    private void sendMessageToPArticularUser(String username, String message) {
        try {
            usernameSessionMap.get(username).getBasicRemote().sendText(message);
        } catch (IOException e) {
            logger.info("Exception: " + e.getMessage().toString());
            e.printStackTrace();
        }


    }

    private void broadcast(String message) {
        sessionUsernameMap.forEach((session, username) -> {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                logger.info("Exception: " + e.getMessage().toString());
                e.printStackTrace();
            }

        });

    }
}
