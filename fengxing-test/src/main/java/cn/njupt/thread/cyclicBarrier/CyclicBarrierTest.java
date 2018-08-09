package cn.njupt.thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by sunfei on 2018/7/22.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4);
        for (int i = 0; i < 10; i ++) {
            new Thread(new Drive(barrier), "thread" + i).start();
        }
    }

    static class Drive implements Runnable{
        private CyclicBarrier cyclicBarrier;

        public Drive(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " begin");
                cyclicBarrier.await();
                System.out.println("execute");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
