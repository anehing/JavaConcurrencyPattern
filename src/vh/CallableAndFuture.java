package vh;


import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by ane on 1/9/15.
 */
public class CallableAndFuture {
    public static void main (String args[]){
        Callable<Integer> callable = () -> { return new Random().nextInt(100);} ;
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask).start();
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(futureTask.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(()->{return new Random().nextInt(100); });
        try {
            TimeUnit.SECONDS.sleep(5);// 可能做一些事情
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
