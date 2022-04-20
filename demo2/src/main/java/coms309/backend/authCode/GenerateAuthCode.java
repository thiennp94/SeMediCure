//package coms309.backend.authCode;
//
///*
//This class will generate an authentication code. Then start a timer on countdown.
//When the timer is finished it will it repeat generating a new code.
// */
//
//public class GenerateAuthCode {
//
//    public static void createAuthCode() {
//        Timer time = new Timer();
////        RandAlphaNum code = new RandAlphaNum(5);
//        int i = 0;
//
//        while(i < 3) {
//            RandAlphaNum code = new RandAlphaNum(5);
//            time.countdown();
//            System.out.println();
//            i++;
//        }
//
//    }
//}

/*
Look into a using a hash funciton.
Generate list hashed list with and X size.  the actual size is the nearest prime number to X
Create a Hash function that is hash(x):
                                     return ((x * r1) + r2) % endSize; //r1 and r2 are random numbers
 */

