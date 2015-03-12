package vh.hash;

/**
 * Created by ane on 3/2/15.
 */
public class Test {
    public static void main(String[] args) {
        MyMap< String, String> mm = new MyMap< String, String>();
        Long aBeginTime=System.currentTimeMillis();           //记录BeginTime
        for(int i=0;i< 1000000;i++){
            mm.put(""+i, ""+i*100);
        }
        Long aEndTime=System.currentTimeMillis();            //记录EndTime
        System.out.println("insert time-->"+(aEndTime-aBeginTime));

        Long lBeginTime=System.currentTimeMillis();          //记录BeginTime
        mm.get(""+100000);
        Long lEndTime=System.currentTimeMillis();            //记录EndTime
        System.out.println("seach time--->"+(lEndTime-lBeginTime));

    }
}
