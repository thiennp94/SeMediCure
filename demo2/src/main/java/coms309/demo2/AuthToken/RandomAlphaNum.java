package coms309.demo2.AuthToken;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomAlphaNum {

    public static void createRandomAlphaNum(){
        String generatedString = RandomStringUtils.randomAlphanumeric(5);

        System.out.println(generatedString);
    }


}
