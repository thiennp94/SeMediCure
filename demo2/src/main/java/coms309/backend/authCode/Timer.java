package coms309.backend.authCode;


import org.springframework.util.StopWatch;

import static java.lang.Thread.sleep;

public class Timer {

    public void countdown() {
        //create timer
        StopWatch timer = new StopWatch();

        //set how long to run the timer. i = time in seconds
        for (int i = 10; i > 0; i--) {
            timer.start();
            runtime(1000);
            timer.stop();
//            System.out.print(i + " ");
        }

        }

    private void runtime(long sleep) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



