package coms309.demo2.AuthToken;

import org.apache.commons.lang3.time.StopWatch;
import java.lang.Object;

public class Timer {

/*
This is all code from the apache commons lang3
 */
    public void countdown(){
        //Create timer
        StopWatch timer = new StopWatch();

        //set how long to run the timer. i = time in seconds
        for(int i=5; i>0; i--) {
            timer.reset();
            timer.start();
            runtime(1000); //1000 = 1 sec
            timer.stop();
            System.out.print(" " + i * (timer.getTime() / 1000));
        }
    }
    private void runtime(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

//    Timer timer = new Timer();
//    timer.schedule(new TimerTask(){
//        @Override
//        public void run() {
//            //what you want to do
//        }
//    }, 0, 1000);//wait 0 ms before doing the action and do it evry 1000ms (1second)
//
//    timer.cancel();//stop the timer
//

}
