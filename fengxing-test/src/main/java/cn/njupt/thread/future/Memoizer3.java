package cn.njupt.thread.future;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by sunfei on 2018/7/21.
 */
public class Memoizer3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private Computable<A, V> c;

    public Memoizer3(Computable c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {
        Future<V> future = cache.get(arg);
        if (future == null) {
            FutureTask futureTask = new FutureTask<>(() -> c.compute(arg));
            cache.put(arg, futureTask);
            futureTask.run();

            future = futureTask;
        }

        try {
            return future.get();
        } catch (Exception e) {
            throw e;
        }

    }
}
