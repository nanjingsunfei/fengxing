package cn.njupt.thread;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by sunfei on 2018/7/20.
 */
public class CopyOnWriteArrayListTest {

    private CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();


    public void test() {
        list.add("123");
        list.add("234");
    }
}
