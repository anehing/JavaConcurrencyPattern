package vh.currence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.sun.org.apache.bcel.internal.generic.NEW;



/**
 * @author ane
 *
 * @version 5:21:21 PM 2014
 *
 */
public class TestMultiThread implements Runnable {
    private static int i;  
    private static volatile Integer vi = 0;  
    private static AtomicInteger ai = new AtomicInteger();  
    private static Integer si = 0; 
    private static Integer si2 = 0; 
    private static int si3 = 0; 
    private static int si4 = 0; 
    private static int ri;  
    private static Object o = new Object();
    private static AtomicInteger flag = new AtomicInteger();  
    private Lock lock = new ReentrantLock();  	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int k=0;k<20000000;k++){  
            i++;  
            vi++;  
            ai.incrementAndGet();  
            synchronized(o){  
                si++;  
            } 
            synchronized(o){  
                si3++;  
            } 
            synchronized(si2){  
                si2++;  
            } 
            
            synchronized(o){    
                si4++;
                Object temp = o;
                for (int i=0;i<10;i++){
                	    
                     o = new Object();    
                      
                }
                o = temp;
            }    

            lock.lock();  
            try{  
                ri++;  
            }finally{  
                lock.unlock();  
            }  
              
        }  
        flag.incrementAndGet(); 
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TestMultiThread t1 = new TestMultiThread();  
        TestMultiThread t2 = new TestMultiThread();  
        ExecutorService exec1 = Executors.newCachedThreadPool();  
        ExecutorService exec2 = Executors.newCachedThreadPool();  
        exec1.execute(t1);  
        exec2.execute(t2); 
        while(true){  
            if(flag.intValue()==2){  
                System.out.println("i>>>>>>"+i);  
                System.out.println("vi>>>>>"+vi);  
                System.out.println("ai>>>>>"+ai); 
                System.out.println("si3>>>>>"+si3); 
                System.out.println("si>>>>>"+si);     
                System.out.println("si2>>>>>"+si2); 
                System.out.println("si4>>>>>"+si4);  
                System.out.println("ri>>>>>"+ri);      
                break;  
            }  
            Thread.sleep(50);  
        }  

	}
}