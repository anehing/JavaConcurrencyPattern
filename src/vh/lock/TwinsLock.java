package vh.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;



public class TwinsLock implements Lock {
	private final Sync  sync  = new Sync(2);


	@Override
	public void lock() {
		// TODO Auto-generated method stub
		sync.acquireShared(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		sync.acquireSharedInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return sync.tryAcquireShared(1) >= 0;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return sync.tryAcquireSharedNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		  sync.releaseShared(1);
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private static final class Sync extends AbstractQueuedSynchronizer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Sync(int count) {
			if (count <= 0) {
				throw new IllegalArgumentException("count must large than zero.");
			}
			setState(count);
		}
		public int tryAcquireShared(int reduceCount){
			for(;;){
				int current = getState();
				int newCount = current - reduceCount;
				if(newCount<0||compareAndSetState(current,newCount)){
					return newCount;
				}
			}
		}
		public boolean tryReleaseShared(int returnCount) {
            for (;;) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
	}
}
