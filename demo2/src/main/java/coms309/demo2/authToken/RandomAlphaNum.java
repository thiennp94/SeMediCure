package coms309.demo2.authToken;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomAlphaNum {

    public static void createRandomAlphaNum(){
        String generatedString = RandomStringUtils.randomAlphanumeric(6);

        System.out.println(generatedString);
    }

}
