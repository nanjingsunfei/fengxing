package cn.njupt.jdk8;

import java.util.function.Supplier;

/**
 * Created by sunfei on 2018/1/5.
 */
public class FibonacciSupplier implements Supplier<Long> {

    long a = 0;
    long b = 1;

    @Override
    public Long get() {
        long x = a + b;
        a = b;
        b = x;
        return a;
    }
}