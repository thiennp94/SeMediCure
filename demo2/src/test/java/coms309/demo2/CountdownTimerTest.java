package coms309.demo2;

import coms309.demo2.AuthToken.AuthCode;
import coms309.demo2.AuthToken.Timer;
import org.apache.commons.lang3.time.StopWatch;

public class CountdownTimerTest {

    public static void main(String[] args) {
        Timer test = new Timer();
        test.countdown();
    }

}
