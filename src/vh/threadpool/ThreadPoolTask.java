package vh.threadpool;

import java.io.Serializable;

public class ThreadPoolTask implements Runnable, Serializable {
	private Object attachData;  
	
	ThreadPoolTask(Object tasks) {  
        this.attachData = tasks;  
    }  
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开始执行任务前：" + attachData);  
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("等时间太长了"); 
		}
		System.out.println("开始执行任务：" + attachData);  
        
        attachData = null;  
	}
	public Object getTask() {  
        return this.attachData;  
    }  
}
