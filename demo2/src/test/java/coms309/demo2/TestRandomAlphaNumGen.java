package coms309.demo2;

import coms309.demo2.AuthToken.RandomAlphaNum;
import org.apache.commons.lang3.RandomStringUtils;

public class TestRandomAlphaNumGen {

    public static void main(String[] args) {
        RandomAlphaNum test = new RandomAlphaNum();
        test.createRandomAlphaNum();
    }

}
