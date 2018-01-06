package cn.njupt.fengxing.dynamicProxy.impl;

import cn.njupt.fengxing.dynamicProxy.inter.Animal;

/**
 * Created by sunfei on 2017/9/21.
 */
public class Cat implements Animal {
    public void eat() {
        System.out.println("I like eating fish!");
    }
}
