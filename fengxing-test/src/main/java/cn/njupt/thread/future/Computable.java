package cn.njupt.thread.future;

/**
 * Created by sunfei on 2018/7/21.
 */
public interface Computable<A, V> {
    V compute(A arg) throws Exception;

}
