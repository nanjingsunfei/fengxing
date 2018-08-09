package cn.njupt.thread.executors;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunfei on 2018/7/23.
 */
public class ExecutorsTest {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ExecutorService executorService1 = Executors.newCachedThreadPool();

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.schedule(() -> {}, 10, TimeUnit.SECONDS);

        executorService.shutdown();
        List<Runnable> runnables = executorService.shutdownNow();

        executorService.isShutdown();

        executorService.isTerminated();

        boolean result = executorService.awaitTermination(10, TimeUnit.SECONDS);

        try {
            executorService.execute(() -> {
                System.out.println("run");
            });
        } catch (RejectedExecutionException e) {
            if (executorService.isShutdown()) {

            }
        }



    }
}
