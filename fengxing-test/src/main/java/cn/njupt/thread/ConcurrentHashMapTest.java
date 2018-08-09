package cn.njupt.thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sunfei on 2018/7/20.
 */
public class ConcurrentHashMapTest {

    private ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

    public void insert(int key, String value) {
        map.putIfAbsent(key, value);
        String oldValue = map.get(key);
        map.remove(key, value);
        map.replace(key, oldValue, value);
    }

    public static void main(String[] args) {

    }

}
