package vh.threadgroup;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
		for (int i = 0; i <5 ; i++) {
			Thread thread = new Thread(threadGroup,searchTask);
			thread.start();
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println(threadGroup.activeCount() + " threads in thread group.");
		System.out.printf("Number of threads : %d\n", threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		threadGroup.list();
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i = 0; i <threadGroup.activeCount() ; i++) {
			System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
		}
		waitFinish(threadGroup);
		threadGroup.interrupt();
	}
    private static void waitFinish(ThreadGroup threadGroup){
		while(threadGroup.activeCount() > 9){
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
