package vh.Future;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by ane on 1/29/15.
 */
public class Memoizer3 <A,V> implements Computable <A,V> {

    private final Map<A,Future<V>> cache = new ConcurrentHashMap<A,Future<V>>();
    private final Computable <A,V> c;

    public Memoizer3 (Computable <A,V> c){
        this.c = c;
    }
    @Override
    public  V compute(A arg) throws InterruptedException {
        V result = null;
        Future <V> f = cache.get(arg);
        if(f == null){
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg,ft);
            ft.run();
        }
        try{
            result = f.get();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        return result;
    }
}
