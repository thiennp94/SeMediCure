package coms309.demo2.authToken;

import org.apache.commons.lang3.time.StopWatch;

public class Timer {
    public void countdown(){
        //Create timer
        StopWatch timer = new StopWatch();

        //set how long to run the timer. i = time in seconds
        for(int i=3; i>0; i--) {
            timer.reset();
            timer.start();
            runtime(1000); //1000 = 1 sec
            timer.stop();
            System.out.print(i* (timer.getTime()/1000) + " ");
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
