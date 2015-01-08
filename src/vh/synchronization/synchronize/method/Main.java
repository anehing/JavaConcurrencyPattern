package vh.synchronization.synchronize.method;

/**
 * Created by ane on 1/7/15.
 */
public class Main {
    public static void main (String args[]){
        Account account = new Account();
        account.setBalance(1000);
        Thread companyThread = new Thread(new Company(account));
        Thread bankThread = new Thread(new Bank(account));
        System.out.printf("Account : Initial Balance: %f\n",account.getBalance());
        companyThread.start();
        bankThread.start();
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance: %f\n",account.getBalance());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
