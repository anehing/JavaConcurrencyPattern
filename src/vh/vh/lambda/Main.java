package vh.vh.lambda;

/**
 * Created by ane on 1/9/15.
 */
public class Main {
    public  static  void main(String args[]){
        Resource.withResource(resource -> resource.dispose());
    }
}
