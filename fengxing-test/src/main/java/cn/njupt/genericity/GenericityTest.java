package cn.njupt.genericity;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunfei on 2018/1/24.
 */
public class GenericityTest {

    public static void main(String[] args) {
        GenericityTest test = new GenericityTest();
        Cat cat = new Cat();
        Cat cat2 = new Cat();
        List<Cat> cats = Lists.newArrayList(cat, cat2);
        test.act(cats);

    }

    private void act(List<? extends Animal> animalList) {
        animalList.stream().forEach(Animal::speak);
    }

    private <T> List<T> getMore(List<T> list) {
        List<T> tList = new ArrayList<>();
        T t = (T)new Object();
        tList.addAll(list);
        tList.add(t);
        return tList;
    }
}
