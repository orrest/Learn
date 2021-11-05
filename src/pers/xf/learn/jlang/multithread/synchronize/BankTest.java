package pers.xf.learn.jlang.multithread.synchronize;

public class BankTest {
    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final double DEAL_LOCK_AMOUNT = 2*MAX_AMOUNT;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        // 将开启多条线程
        for(int i = 0; i < NACCOUNTS; i++){
            int fromAccount = i;
            Runnable r = () -> {
                try{
                    while (true){
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = DEAL_LOCK_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                }catch (InterruptedException e){

                }
            };
            var t = new Thread(r);
            t.start();
        }
    }
}
