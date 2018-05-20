package cn.njupt.thread.blockingQueue;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by sunfei on 2018/5/20.
 */
public class BQ {
    private static ArrayBlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ", 开始执行");
                    Integer value = blockingDeque.take();
                    System.out.println(value);
                    System.out.println(Thread.currentThread().getName() + ", 结束");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(10000);


        Random random = new Random();
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        list.stream().forEach(value -> System.out.println(value));

        System.out.println("队列插入值-start");
        blockingDeque.addAll(list);
        System.out.println("队列插入值-done");



    }
}
