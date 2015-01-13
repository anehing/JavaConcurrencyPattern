package vh.uncontrolled.exception;

/**
 * Created by ane on 1/7/15.
 */
public class MyThreadGroup extends ThreadGroup{
    public MyThreadGroup(String name){
        super(name);
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("the thread %s has thrown an Exception\n",t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the Threads\n");
        interrupt();
    }
}
