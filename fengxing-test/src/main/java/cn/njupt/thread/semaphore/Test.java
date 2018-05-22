package cn.njupt.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by sunfei on 2018/5/22.
 */
public class Test {
    public static void main(String[] args) {
        Driver driver = new Driver();
        for (int i = 0; i < 10; i++) {
            new Car(driver).start();
        }
    }


    static class Driver {
        private Semaphore semaphore = new Semaphore(1);

        public void doDrive() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "开始执行");
                Thread.sleep(3000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "执行结束");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Car extends Thread {

        private Driver driver;

        public Car(Driver driver) {
            this.driver = driver;
        }

        @Override
        public void run() {
            driver.doDrive();
        }
    }


}
