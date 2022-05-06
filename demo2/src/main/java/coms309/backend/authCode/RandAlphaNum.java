package coms309.backend.authCode;

import java.util.Random;

public class RandAlphaNum {

   public void createAuthCode(){
      int leftLimit = 48;
      int rightLimit = 90;
      int codeLength = 6;
      Random random = new Random();

      String alphanum = random.ints(leftLimit, rightLimit+1)
              .filter(i -> (i <= 57 || i >= 65) )
              .limit(codeLength)
              .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
              .toString();

//      System.out.print(alphanum);
   }

}
