package cn.njupt.thread.deadLock;

/**
 * Created by sunfei on 2018/8/5.
 */
public class Account {
    private DollarAmount dollarAmount;

    public DollarAmount getBalance() {
        return dollarAmount;
    }

    public void debit(DollarAmount amount) {
        dollarAmount.setAmount(dollarAmount.getAmount() - amount.getAmount());
    }

    public void credit(DollarAmount amount) {
        dollarAmount.setAmount(dollarAmount.getAmount() + amount.getAmount());
    }

}
