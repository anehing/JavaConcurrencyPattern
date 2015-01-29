package vh.fork_join;
import java.util.*;
/**
 * Created by ane on 1/20/15.
 */
public class ProductListGenerator {
    public List<Product> generate(int size){
        List<Product> ret=new ArrayList<Product>();
        for(int i=0;i<size;i++){
            Product product = new Product();
            product.setName("product" + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
