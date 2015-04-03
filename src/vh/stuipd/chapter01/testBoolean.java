package vh.stuipd.chapter01;

/**
 * Created by ane on 3/13/15.
 */
public class testBoolean {
    interface A{
      public abstract void  test(int a);

    }
    public static void main(String []args) {
         int a =1001;
        new A(){
            @Override
            public void test(int a) {
                System.out.println(a);
            }
        };
        System.out.println(a);
    }
}
