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
    private static Integer si_obj = 0; 
    private static int sio1 = 0; 
    private static int sio = 0; 
    private static int sio2 = 0;
    private static int ri;  
    private static Object o = new Object();
    private static Object o1 = new Object();
    private static Object o2 = new Object();
    private static AtomicInteger flag = new AtomicInteger();  
    private Lock lock = new ReentrantLock();  	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int k=0;k<200000000;k++){  
            i++;  
            vi++;  
            ai.incrementAndGet();  
            synchronized(si){  
                si++;  
            } 
            synchronized(o){  
                sio++; 
                si_obj++;
            } 
            synchronized(o1){  
                sio1++;  
                o1 = new Object();
            } 
           
            
            synchronized(o2){    
                sio2++;
                Object temp = o2;
                for (int i=0;i<10;i++){
                	    
                     o2 = new Object();    
                      
                }
                o2 = temp;
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
                System.out.println("si>>>>>"+si); 
                System.out.println("except sio == si_obj");  
                System.out.println("sio>>>>>"+sio); 
                System.out.println("si_obj>>>>>"+si_obj); 
                System.out.println("except sio2 < sio1"); 
                System.out.println("sio1>>>>>"+sio1);     
                System.out.println("sio2>>>>>"+sio2); 
                System.out.println("ri>>>>>"+ri);      
                break;  
            }  
            Thread.sleep(50);  
        }  
	}
}