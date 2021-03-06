package vh.concurrent.ConcurrentHashMap;

import java.util.Map;

/**
 * Created by ane on 3/5/15.
 */

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


public class TTT {

    private static Map<Long, ServiceDO> widgetCacheMap = new ConcurrentHashMap<Long, ServiceDO>();
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(int i=0;i<1000000;i++){
            Thread tt = new Thread(new Rund());
            tt.start();
        }
    }

    static class Rund implements Runnable {

        public void run() {
            // TODO Auto-generated method stub
            test();
        }

        /**
         * 1W次，总有那么几次线程不安全
         */
        public void test(){
            TTT tt = new TTT();
            tt.set();
            int s1 = widgetCacheMap.get(1L).getStatus();
            tt.change();
            int s2 = widgetCacheMap.get(1L).getStatus();
            if(s1==s2){
                System.out.println(s1+":"+s2);
            }
        }

    }



    public void set() {
        Map mm= new HashMap();
        ServiceDO ss = new ServiceDO();
        ss.setStatus(1);
        mm.put(1L, ss);
        widgetCacheMap = mm;
    }
    public void change(){
        Map mm= new HashMap();
        ServiceDO ss = new ServiceDO();
        ss.setStatus(2);
        mm.put(1L, ss);
        widgetCacheMap = mm;
    }

}

