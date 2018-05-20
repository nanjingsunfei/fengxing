package cn.njupt.thread.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sunfei on 2018/5/14.
 */
public class Worker implements Runnable{

    //工作者名
    private String name;
    //第一阶段工作时间
    private long time;

    private CountDownLatch countDownLatch;

    public Worker(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name+"开始工作");
            Thread.sleep(time);
            System.out.println(name+"第一阶段工作完成");

            countDownLatch.countDown();

            Thread.sleep(2000); //这里就姑且假设第二阶段工作都是要2秒完成
            System.out.println(name+"第二阶段工作完成");
            System.out.println(name+"工作完成，耗费时间="+(time+2000));

        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(new Worker("thread-1 ", 1000, countDownLatch));
        Thread t2 = new Thread(new Worker("thread-2 ", 2000, countDownLatch));
        Thread t3 = new Thread(new Worker("thread-3 ", 3000, countDownLatch));

        t1.start();
        t2.start();

        countDownLatch.await();

        t3.start();
    }
}