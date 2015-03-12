package vh.test;

/**
 * Created by ane on 2/3/15.
 */
public class Constructor {
    public Constructor(String s){
        this(s,true);
    }
    public Constructor(String s, boolean fair){
        if(fair){
            System.out.print("hello  ");
        }
        System.out.print(s);
    }
    public static void main(String args[]){
        Constructor c = new Constructor("world");
         System.out.println(1<<13);
    }
}
