package vh.synchronization.synchronize.method;

import java.util.concurrent.TimeUnit;

/**
 * Created by ane on 1/7/15.
 */
public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void addAmount(double amount){
        double tmp = balance;
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        tmp += amount;
        balance = tmp;
    }
    public synchronized  void subtractAmount (double amount){
        double tmp = balance;
        try{
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        tmp -= amount;
        balance = tmp;
    }
}
