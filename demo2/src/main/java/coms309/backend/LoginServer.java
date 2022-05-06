package coms309.backend;

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

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import coms309.backend.patient.PatientRepository;
import coms309.backend.user.User;

@ServerEndpoint("/login/{usertype}/{username}/{password}")
@Component
public class LoginServer {

  // Store all socket session and their corresponding username.
  private static Map < Session, String > sessionUsernameMap = new Hashtable < > ();
  private static Map < String, Session > usernameSessionMap = new Hashtable < > ();
  private String passWd;
  private String usrType;

  private final Logger logger = LoggerFactory.getLogger(LoginServer.class);

  @OnOpen
  public void onOpen(Session session, @PathParam("usertype") String usertype, @PathParam("username") String username, @PathParam("password") String passWord)
  throws IOException {
    logger.info("Entered into Open");

    sessionUsernameMap.put(session, username);
    usernameSessionMap.put(username, session);
    passWd = passWord;
    usrType = usertype;
  }

  @OnMessage
  public void onMessage(Session session, String message) throws IOException {
    // Handle new messages
    logger.info("Entered into Message: Got Message:" + message);
    String username = sessionUsernameMap.get(session);
    String mssg = "";
    
    PatientRepository patientRepository;
    //created a new JSON object to put the user JSON data in during the login process.
    JSONObject output = new JSONObject();
    
    JSONObject LoginEmailVerification(@RequestParam String email, @RequestParam String password) {
        User temp = patientRepository.findByEmail(email);
        if (temp == null) {
            output.put("status", 1); //status code for wrong email
            output.put("userInfo", null);
        }
        if (!password.equals(temp.getPassword())) {
            output.put("status", 2); //status code for incorrect password
            output.put("userInfo", null);
        } else {
            output.put("status", 3); //status code for correct login information
            output.put("userInfo", temp);

        }
    
        sendConfirm(username, output);

     }
  	}

  @OnClose
  public void onClose(Session session) throws IOException {
    logger.info("Entered into Close");

    String username = sessionUsernameMap.get(session);
    sessionUsernameMap.remove(session);
    usernameSessionMap.remove(username);
  }

  @OnError
  public void onError(Session session, Throwable throwable) {
    // Do error handling here
    logger.info("Entered into Error");
  }

  private void sendConfirm(String username, JSONObject confirm) {
    try {
      usernameSessionMap.get(username).getBasicRemote().sendObject(confirm);
    } catch (Exception e) {
      logger.info("Exception: " + e.getMessage().toString());
      e.printStackTrace();
    }
  }
}