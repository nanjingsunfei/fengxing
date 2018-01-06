package cn.njupt.jkd7;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunfei on 2018/1/6.
 */
public class JDK7Test {

    public static void main(String[] args) {
        collectionsSupport();
        enumUpgrade();
    }

    private static void collectionsSupport() {
        Map<String, Integer> map = new HashMap<>();
        map.put("key", 1);
        int value = map.get("key");
        System.out.println(value);
    }

    private static void enumUpgrade() {
        String ss = "test";

        switch (ss) {
            case "test":
                System.out.println(1);
                break;
            default:
                System.out.println(2);
        }
    }

}
