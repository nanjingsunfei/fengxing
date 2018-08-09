package cn.njupt.thread.deadLock;

/**
 * Created by sunfei on 2018/8/5.
 */
public class DollarAmount {

    private int amount = 1000;

    public DollarAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int compareTo(DollarAmount dollarAmount) {
        return Integer.valueOf(this.amount).compareTo(Integer.valueOf(dollarAmount.getAmount()));
    }
}
