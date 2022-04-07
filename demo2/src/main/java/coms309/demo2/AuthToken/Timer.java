package coms309.demo2.AuthToken;

import org.apache.commons.lang3.time.StopWatch;

public class Timer {
    private void countdown(){
        //Create timer
        StopWatch timer = new StopWatch();

        //set how long to run the timer. i = time in seconds
        for(int i=10; i>0; i--) {
            timer.reset();
            timer.start();
            runtime(1000); //1000 = 1 sec
            timer.stop();
            System.out.println("Time: " + i* (timer.getTime()/1000));
        }
    }
    private void runtime(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    

}
