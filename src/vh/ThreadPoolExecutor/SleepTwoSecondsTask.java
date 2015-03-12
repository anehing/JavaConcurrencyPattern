package vh.ThreadPoolExecutor;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by ane on 2/4/15.
 */
public class SleepTwoSecondsTask implements Callable {
    @Override
    public Object call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return new Date().toString();
    }
}
