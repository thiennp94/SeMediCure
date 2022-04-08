package coms309.demo2.authToken;


/*  This class will start the timer on a countdown create the authentication code,
    store it in the patient database and then when the timer ends repeat the process.
 */
public class AuthCode {

    public static void createAuthCode() {
        Timer time = new Timer();
        RandomAlphaNum code = new RandomAlphaNum();
        int i = 0;

        while (i < 3) {
            code.createRandomAlphaNum();
            time.countdown();
            System.out.println();
            i++;
        }

    }

    //if( currDate > endDate)
//    update authCode;
//}

}
