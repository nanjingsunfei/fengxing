package cn.njupt.thread.future;

import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by sunfei on 2018/7/21.
 */
public class Memoizer4<A, V> implements Computable<A, V> {
    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private Computable<A, V> c;

    public Memoizer4(Computable c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {
        for (;;) {
            Future<V> future = cache.get(arg);
            if (future == null) {
                FutureTask futureTask = new FutureTask<>(() -> c.compute(arg));
                future = cache.putIfAbsent(arg, futureTask);
                if (future == null) {
                    futureTask.run();
                    future = futureTask;
                }
            }

            try {
                return future.get();
            } catch (CancellationException e) {
                cache.remove(arg, future);
            } catch (Exception e) {
                throw e;
            }
        }

    }
}
