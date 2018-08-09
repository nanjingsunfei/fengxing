package cn.njupt.thread.deadLock;

import javax.naming.InsufficientResourcesException;

/**
 * Created by sunfei on 2018/8/5.
 */
public class BankTransfer {
    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAcct,
                              final Account toAcct,
                              final DollarAmount amount) {

        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);

        if (fromHash > toHash) {
            synchronized (fromAcct) {
                synchronized (toAcct) {
                    new Helper().transfer(fromAcct, toAcct, amount);
                }
            }
        } else if (fromHash < toHash) {
            synchronized (toAcct) {
                synchronized (fromAcct) {
                    new Helper().transfer(fromAcct, toAcct, amount);
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAcct) {
                    synchronized (toAcct) {
                        new Helper().transfer(fromAcct, toAcct, amount);
                    }
                }
            }
        }
    }

    class Helper {
        public void transfer(Account fromAcct, Account toAcct, DollarAmount amount) {
            if (fromAcct.getBalance().compareTo(amount) < 0) {
                System.out.println();
            } else {
                fromAcct.debit(amount);
                toAcct.credit(amount);
            }
        }
    }
}
