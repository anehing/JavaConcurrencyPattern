package vh.local.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
  
//   private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
//	  protected Date initialValue(){
//		  return new Date();
//	  }
//   };
   private static ThreadLocal<Date> startDate = ThreadLocal.withInitial(Date::new);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate.get());
	}
}
