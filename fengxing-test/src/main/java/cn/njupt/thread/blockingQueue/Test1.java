package cn.njupt.thread.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunfei on 2018/7/20.
 */
public class Test1 {
    private BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(4);

    public static void main(String[] args) {
        final Test1 test1 = new Test1();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    test1.blockingQueue.put("value" + i);
                    System.out.println("insert value " + i);
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(test1.blockingQueue.take());
                } catch (Exception e) {

                }

            }
        }).start();
    }

    public void test2() throws Exception {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>(4);
        String value = "123";
        queue.add(value);
        queue.remove();

        queue.offer(value, 10, TimeUnit.SECONDS);
        queue.poll(10, TimeUnit.SECONDS);

        queue.put(value);
        queue.take();
    }
}
