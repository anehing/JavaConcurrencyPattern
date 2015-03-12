package vh.threadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class Task implements Runnable{
	int taskId;
	public Task (int taskId) {
		this.taskId = taskId;		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"--taskId:"+taskId);
	}
	
}
class DaemonThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thread = new Thread();
		thread.setDaemon(true);
		return thread;
	}
	
}
/**
 * @author ane
 *
 * @version 2:00:18 PM 2014
 *
 */
public class ThreadFactorytest {

	public static void main(String[] args)  {
		// TODO Auto-generated method stubq
		ExecutorService es = Executors.newFixedThreadPool(3,new DefaultThreadFactory());	
		for(int i=0;i<10;i++){
			Task task = new Task(i);
			es.submit(task);
		}
		es.shutdown();
		System.out.println("over");
		
	}
}
