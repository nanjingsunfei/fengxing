package cn.njupt.thread.future;

import java.math.BigInteger;

/**
 * Created by sunfei on 2018/7/21.
 */
public class ExpressiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws Exception {
        return new BigInteger(arg);
    }
}
