package vh.fork_join;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by ane on 1/20/15.
 */
public class Task extends RecursiveAction {
    private static final long serialVersionUID = 1L;
    private List<Product> products;
    private int first;
    private int last;
    private double increment;

    public Task(List<Product> products,int first,int last, double increment){
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }
    @Override
    protected void compute() {
        if(last - first < 10){
            updatePrices();
        }else{
            int middle = (last+first)/2;
            System.out.printf("Task: pending tasks: %s\n", getQueuedTaskCount());
            Task t1 = new Task(products,first,middle+1,increment);
            Task t2 = new Task(products,middle +1,last,increment);
            invokeAll(t1,t2);
        }
    }

    private void updatePrices(){
        for(int i = first; i<last;i++){
            Product product = products.get(i);
            product.setPrice(product.getPrice()*(1+increment));
        }
    }
}
