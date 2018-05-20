package cn.njupt;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by sunfei on 2018/5/9.
 */
public class Test {
    public static void main(String[] args) {
        List<String> orderids = Lists.newArrayList("a", "b");
        StringBuilder sb = new StringBuilder();
        for (String orderId : orderids) {
            if (StringUtils.isNotBlank(orderId)) {
                sb.append(orderId).append(",");
            }
        }
        String s = sb.substring(0, sb.length() - 1);

        System.out.println(s);
    }
}
