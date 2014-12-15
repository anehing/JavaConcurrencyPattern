package vh.Static;

public class ExceptionTest {

    public static void throwit(){
        throw new RuntimeException();
    }

    public static void main (String[]args){
        try{
            System.out.println("Hello");
          //  throwit(); // doesn't compile if this line is replaced with throw new RuntimeException.
            throw new RuntimeException();
           // System.out.println("Done");
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally");
        }   
    }
}