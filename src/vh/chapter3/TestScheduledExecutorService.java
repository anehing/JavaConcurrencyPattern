package vh.chapter3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class TestScheduledExecutorService {


    public static void main(String[] args) throws Exception {

        ScheduledExecutorService execService = Executors.newScheduledThreadPool(3);
        // 5秒后开始执行 每个2秒执行一次，如果有的任务执行要花费比其周期更长的时间，则将推迟后续执行，但不会同时执行
//        每次相隔相同的时间执行任务，如果任务的执行时间比周期还长，那么下一个任务将立即执行
        execService.scheduleAtFixedRate(new Runnable() {

         ThreadLocal<Integer> i = new ThreadLocal<Integer>() {
             AtomicInteger  nextId = new AtomicInteger(0);
             @Override protected Integer initialValue(){
                 int i = 0;
                 return ++i;
             }
         };

            public void run() {
                System.out.println("任务1：" + Thread.currentThread().getName() + " 执行了，时间为： " + System.currentTimeMillis()+" "+i.get());
                try {
                     if (i.get()==3) {
                          System.out.println("========================================");
                         TimeUnit.SECONDS.sleep(1);
                     }
//                     if (i.get()==1)  TimeUnit.SECONDS.sleep(1);
//                     if (i.get()==2)  TimeUnit.SECONDS.sleep(1);
                     if (i.get()==4)  TimeUnit.SECONDS.sleep(10);
                     if (i.get()==5)  TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 5, 2, TimeUnit.SECONDS);
        //5秒后开始执行 每个2秒执行一次，保证固定的延迟为2秒 下一个任务的开始时间与上一个任务的结束时间间隔相同
// if (i.get()==1)  TimeUnit.SECONDS.sleep(1);ixedDelay(new Runnable() {
//            public void run() {
//                j.incrementAndGet();
//                System.out.println("任务2：" + Thread.currentThread().getName() + " 执行了，时间为： " + System.currentTimeMillis()+" "+j.get());
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }, 5, 2, TimeUnit.SECONDS);
//        Thread.sleep(10000L);
//        execService.shutdown();
    }
}
