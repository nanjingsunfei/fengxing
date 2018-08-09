package cn.njupt.thread.executors;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by sunfei on 2018/7/24.
 */
public class CompletionServiceTest {
    private final ExecutorService executorService;

    public CompletionServiceTest(ExecutorService executorService) {
        this.executorService = executorService;
    }


    void renderpage(CharSequence source) {
        List<String> infos = scanForInfo(source);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        for (final String info : infos) {
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return info;
                }
            });
        }

        try {
            for (int i = 0; i < infos.size(); i++) {
                Future<String> future = completionService.take();
                String data = future.get(10, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    List<String> scanForInfo(CharSequence source) {
        return Lists.newArrayList();
    }
}
