package vh.Future;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

/**
 * Created by ane on 1/29/15.
 */
public class ExpensiveFunction implements Computable <String,BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        return new BigInteger(arg);
    }
}
