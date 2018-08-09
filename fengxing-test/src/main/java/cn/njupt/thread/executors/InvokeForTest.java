package cn.njupt.thread.executors;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunfei on 2018/7/24.
 */
public class InvokeForTest {

    private final ExecutorService executorService;

    public InvokeForTest(ExecutorService executorService) {
        this.executorService = executorService;
    }

    private List<String> getQuotes(List<String> infos) {

        List<QuoteTask> tasks = new ArrayList<>();
        for (String info : infos) {
            tasks.add(new QuoteTask(info));
        }
        try {
            List<Future<String>> futures = executorService.invokeAll(tasks, 10, TimeUnit.SECONDS);
            for (Future<String> future : futures) {
                future.get();
            }
        } catch (Exception e) {

        }
        return null;

    }


    private class QuoteTask implements Callable<String> {
        private final String info;
        public QuoteTask(String info) {
            this.info = info;
        }

        @Override
        public String call() throws Exception {
            return null;
        }
    }

}
