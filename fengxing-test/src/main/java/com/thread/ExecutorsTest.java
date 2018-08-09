package com.thread;

import sun.plugin2.jvm.CircularByteBuffer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunfei on 2018/7/4.
 */
public class ExecutorsTest {

    public static void main(String[] args) {
        ExecutorsTest executorsTest = new ExecutorsTest();
        executorsTest.testFixedThreadPool();
//        executorsTest.testCachedThreadPool();
//        executorsTest.testScheduledThreadPool();
//        executorsTest.testSingleThredPool();
    }

    public void testFixedThreadPool() {
        ExecutorService singleThreadPool = Executors.newFixedThreadPool(1);
        for (int i = 1; i <= 5; i++) {
            int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("第" + index + "个线程");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void testCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " end...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " end...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " end...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void testScheduledThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        System.out.println("start");
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        scheduledExecutorService.schedule(() -> {
            try {
                long endTime = System.currentTimeMillis();
                System.out.println(endTime);
                System.out.println(endTime - startTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 10, TimeUnit.SECONDS);
    }

    public void testSingleThredExecutor() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++) {
            int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("第" + index + "个线程");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void testCallable() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(() -> {
            return "123";
        });

        try {
            String result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
