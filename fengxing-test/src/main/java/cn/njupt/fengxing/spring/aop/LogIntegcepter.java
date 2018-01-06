package cn.njupt.fengxing.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sunfei on 2017/9/24.
 */
public class LogIntegcepter implements InvocationHandler{

    private Object target;

    public LogIntegcepter(Object target) {
        this.target = target;
    }


    public void beforeMethod(Method method) {

        System.out.println(method.getName() + " start ..");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        beforeMethod(method);
        method.invoke(target, args);
        return null;
    }
}
