package cn.njupt.thread.deadLock;

import java.util.Random;

/**
 * Created by sunfei on 2018/8/5.
 */
public class DemonstrateDeadLock {

    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNT = 5;
    private static final int NUM_ITERATIONS = 1000000;

    public static void main(String[] args) throws Exception {
        final Random rnd = new Random();
        final Account[] accounts = new Account[NUM_ACCOUNT];
        final BankTransfer bankTransfer = new BankTransfer();

        for (int i = 0; i < accounts.length; i ++) {
            accounts[i] = new Account();
        }

        class TransferThread extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    int fromAcct = rnd.nextInt(NUM_ACCOUNT);
                    int toAcct = rnd.nextInt(NUM_ACCOUNT);
                    DollarAmount amount = new DollarAmount(rnd.nextInt(1000));
                    bankTransfer.transferMoney(accounts[fromAcct], accounts[toAcct], amount);
                }
            }
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            new TransferThread().start();
        }
        System.exit(0);
    }



}
