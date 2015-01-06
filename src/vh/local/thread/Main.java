package vh.local.thread;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UnsafeTask task = new UnsafeTask();
		SafeTask task = new SafeTask();
		for(int i = 0;i<10;i++){
		  Thread thread = new Thread(task);
		  thread.start();
		  try{
			  TimeUnit.SECONDS.sleep(2);
		  } catch(InterruptedException e){
			  e.printStackTrace();
		  }
		}
	}

}
