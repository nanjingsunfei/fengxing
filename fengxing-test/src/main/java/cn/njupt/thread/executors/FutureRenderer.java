package cn.njupt.thread.executors;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by sunfei on 2018/7/24.
 */
public class FutureRenderer {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    void renderPage(CharSequence source) {
        final List<String> infos = scanForInfo(source);
        Callable<List<String>> task = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                List<String> result = new ArrayList<>();
                for (String info : infos) {
                    result.add(info);
                }
                return result;
            }
        };
        Future<List<String>> future = executorService.submit(task);

        try {
            List<String> datas = future.get();
            for (String data : datas) {

            }
        } catch (Exception e) {

        }
    }

    List<String> scanForInfo(CharSequence source) {
        return Lists.newArrayList();
    }
}
