package cn.njupt.jdk8;

import java.util.List;

/**
 * Created by sunfei on 2018/1/25.
 */
public class Utils {
    public static void paint(List<Resizable> list) {
        list.forEach(r -> {
            r.setAbsoluteSize(42, 42);
        });
    }
}
