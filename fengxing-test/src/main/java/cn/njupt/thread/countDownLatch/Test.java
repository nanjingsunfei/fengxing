package cn.njupt.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sunfei on 2018/5/6.
 */
public class Test {


    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("线程1执行");
                    Thread.sleep(3000);
                    System.out.println("线程1执行结束");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("线程2执行");
                    Thread.sleep(3000);
                    System.out.println("线程2执行结束");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            System.out.println("主线程开始执行");
            latch.await();
            System.out.println("主线程继续执行");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
