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
    private static int num;
    private static volatile Integer vi = 0; 
    private static  long long1 = 0; 
    private static  long long2 = 0; 
    private static volatile long v_long = 0; 
    private static volatile long v_long2 = 0; 
    private static double double1 = 0; 
    private static double double2 = 0; 
    private static volatile double v_dou= 0;
    private static volatile double v_dou2= 0; 
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
    private static int num(){
		return num++;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int k=0;k<200000000;k++){ 
			num();
			long1++;
			double1++;
			v_long++;
			v_dou++;
            i++;  
            vi++;  
            ai.incrementAndGet();  
            synchronized(si){  
                si++;  
            } 
            synchronized(o){  
                sio++; 
                si_obj++;
                v_long2++;
                v_dou2++;
                long2++;
                double2++;
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
            	System.out.println("num()>>>>>>"+num);
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
                System.out.println("long1>>>>>>"+long1);  
                System.out.println("long2 in synchronized>>>>>"+long2);  
                System.out.println("double2 in synchronized>>>>>"+double2);
                System.out.println("double1>>>>>"+double1);
                System.out.println("v_long>>>>>"+v_long);
                System.out.println("v_long2 in synchronized >>>>>"+v_long2);
                System.out.println("v_dou1>>>>>"+v_dou);
                System.out.println("v_dou2 in synchronized >>>>>"+v_dou2);
                break;  
            }  
            Thread.sleep(50);  
        }  
	}
}