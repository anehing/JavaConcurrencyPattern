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
		System.out.println("开始执行任务：" + attachData);  
        
        attachData = null;  
	}
	public Object getTask() {  
        return this.attachData;  
    }  
}
