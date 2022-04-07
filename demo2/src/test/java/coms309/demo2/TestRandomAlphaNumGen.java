package coms309.demo2;

import org.apache.commons.lang3.RandomStringUtils;

public class TestRandomAlphaNumGen {

    public static void createRandomAlphaNum(){
        String generatedString = RandomStringUtils.randomAlphanumeric(6);
        System.out.println(generatedString);
    }

    public static void main(String[] args) {
        createRandomAlphaNum();
    }

}
