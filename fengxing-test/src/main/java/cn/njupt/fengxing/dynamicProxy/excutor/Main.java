package cn.njupt.fengxing.dynamicProxy.excutor;

import cn.njupt.fengxing.dynamicProxy.handler.ReadyInvocationHandler;
import cn.njupt.fengxing.dynamicProxy.impl.Cat;
import cn.njupt.fengxing.dynamicProxy.inter.Animal;

import java.lang.reflect.Proxy;

/**
 * Created by sunfei on 2017/9/21.
 */
public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat();

        Animal newCat = (Animal)Proxy.newProxyInstance(cat.getClass().getClassLoader(), cat.getClass().getInterfaces(),
                new ReadyInvocationHandler(cat));
        System.out.println(newCat.getClass().getName());
        newCat.eat();
    }
}
