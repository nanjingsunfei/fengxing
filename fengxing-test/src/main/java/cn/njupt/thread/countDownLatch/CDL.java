package cn.njupt.thread.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sunfei on 2018/5/20.
 */
public class CDL implements Runnable {
    private String name;

    private CountDownLatch countDownLatch;

    public CDL(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ", start");
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + ", end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new CDL("1", countDownLatch));

        Thread t2 = new Thread(new CDL("1", countDownLatch));

        t1.start();
        t2.start();

        Thread.sleep(10000);
        System.out.println("count down");
        countDownLatch.countDown();
    }
}
