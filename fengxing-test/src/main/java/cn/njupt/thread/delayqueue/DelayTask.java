package cn.njupt.thread.delayqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunfei on 2018/7/23.
 */
public class DelayTask implements Delayed {

    private String name;
    private Long delayTime;
    private TimeUnit delayTimeUnit;
    private Long executeTime;

    public DelayTask(String name, Long delayTime, TimeUnit delayTimeUnit) {
        this.name = name;
        this.delayTime = delayTime;
        this.delayTimeUnit = delayTimeUnit;
        this.executeTime = System.currentTimeMillis() + delayTimeUnit.toMillis(delayTime);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        DelayQueue<DelayTask> delayQueue = new DelayQueue<>();
        delayQueue.add(new DelayTask("1", 1l, TimeUnit.SECONDS));
        delayQueue.add(new DelayTask("2", 3l, TimeUnit.SECONDS));
        delayQueue.add(new DelayTask("3", 2l, TimeUnit.SECONDS));

        System.out.println("queue put done");

        while (!delayQueue.isEmpty() ) {
            try {
                DelayTask delayTask = delayQueue.take();
                System.out.println(delayTask.name + ":" + (System.currentTimeMillis() - currentTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
