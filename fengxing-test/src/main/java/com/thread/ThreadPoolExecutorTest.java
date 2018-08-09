package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunfei on 2018/7/6.
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutorTest test = new ThreadPoolExecutorTest();
        try {
            test.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                20,
                20,
                0l,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        String result = "";
        Future<String> future = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        }, result);

        Future<String> future1 = threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "2";
            }
        });
        System.out.println(future1.get());

    }
}
