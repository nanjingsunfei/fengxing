package cn.njupt.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by sunfei on 2018/7/21.
 */
public class SemaphoreTest implements Runnable {

    private Semaphore semaphore;

    public SemaphoreTest(Semaphore semaphore) {
        this.semaphore = semaphore;
    }


    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " 执行");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " end");
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i< 10; i++) {
            new Thread(new SemaphoreTest(semaphore)).start();
        }
    }
}
