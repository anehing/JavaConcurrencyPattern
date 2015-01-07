package vh.uncontrolled.exception;

import java.util.Random;

/**
 * Created by ane on 1/7/15.
 */
public class Task implements  Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while(true){
            result=1000/((int)(random.nextDouble()*1000));
            System.out.printf("%s :: %f\n",Thread.currentThread().getId(),result);
            if (Thread.currentThread().isInterrupted()){
                System.out.printf("%d : Interrupted\n",Thread.currentThread().getId());
                return;
            }
        }
    }
}
