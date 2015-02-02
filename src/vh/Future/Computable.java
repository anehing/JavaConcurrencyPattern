package vh.Future;

import java.math.BigInteger;

/**
 * Created by ane on 1/29/15.
 */
public interface Computable <A,V> {
    V compute(A arg) throws InterruptedException;
}

