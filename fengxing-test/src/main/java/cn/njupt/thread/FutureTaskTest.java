package cn.njupt.thread;

import java.util.concurrent.FutureTask;

/**
 * Created by sunfei on 2018/7/21.
 */
public class FutureTaskTest {

    private final FutureTask<String> futureTask = new FutureTask<>(() -> {
        System.out.println("begin");
        Thread.sleep(20000);
        return "OK";
    });

    public void start() {
        new Thread(futureTask).start();
    }

    public String get() {
        try {
            System.out.println("get begin");
            return futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FutureTaskTest futureTaskTest = new FutureTaskTest();
        futureTaskTest.start();
        System.out.println(futureTaskTest.get());
    }


}
