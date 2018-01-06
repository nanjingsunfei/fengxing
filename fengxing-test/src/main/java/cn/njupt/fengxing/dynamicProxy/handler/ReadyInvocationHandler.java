package cn.njupt.fengxing.dynamicProxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sunfei on 2017/9/21.
 */
public class ReadyInvocationHandler implements InvocationHandler {

    private Object realSubject = null;

    public ReadyInvocationHandler(Object realSubject) {
        this.realSubject = realSubject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("吃饭先洗手");
        Object result = method.invoke(realSubject, args);
        System.out.println("饭后要散步");

        return result;
    }
}
