package vh.threadfactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ane
 *
 * @version 2:00:06 PM 2014
 *
 */
public class DefaultThreadFactory implements ThreadFactory {

	public static final AtomicInteger poolNumber =new AtomicInteger(1);
	final ThreadGroup group;
	final AtomicInteger threadNumber =  new AtomicInteger(1);
	final String namePrefix;
	
	public DefaultThreadFactory() {
		// TODO Auto-generated constructor stub
		SecurityManager s =System.getSecurityManager();
		group = (s!=null)? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
		
		namePrefix = "pool-"+ poolNumber.getAndIncrement() +"-thread-";
	}
	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(group,r,namePrefix+threadNumber.getAndIncrement(),0);
		
		if(thread.isDaemon()) thread.setDaemon(false);
		if(thread.getPriority()!=Thread.NORM_PRIORITY) thread.setPriority(Thread.NORM_PRIORITY);
		
		return thread;
	}
	
	

}
