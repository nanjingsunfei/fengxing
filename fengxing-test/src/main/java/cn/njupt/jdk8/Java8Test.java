package cn.njupt.jdk8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sunfei on 2018/1/31.
 */
public class Java8Test {
    public static void main(String[] args) {
        Java8Test java8Test = new Java8Test();
        java8Test.testP2();
    }

    private void testP2() {
        Thread t = new Thread(() -> System.out.println("Hello world"));
        t.start();
    }

    private void testP3() {
        Map<Integer, List<String>> map = new HashMap<>();

        Map<String, List<String>> map2 = map.entrySet().stream().collect(Collectors.toMap(entry -> String.valueOf(entry.getKey()), entry -> entry.getValue()));


        List<Shop> shops = new ArrayList<>();
        Map<String, List<Shop>> shopMap = shops.stream().collect(Collectors.groupingBy(Shop::getName));

        Map<String, List<String>> map3 = shopMap.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().stream().map(Shop::getDesc).collect(Collectors.toList())));
    }
}
