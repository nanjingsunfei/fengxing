package cn.njupt;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by sunfei on 2018/5/9.
 */
public class Test {
    public static void main(String[] args) {

        String s = getSecondDiscountTip(BigDecimal.valueOf(0.51));

        System.out.println(s);
    }

    public static String getSecondDiscountTip(BigDecimal discount) {
        String tip = "";
        if (discount == null) {
            return tip;
        }
        if (BigDecimal.valueOf(0.5).compareTo(discount) == 0) {
            tip = "半价";
        } else {
            DecimalFormat df = new DecimalFormat("#.#");
            tip = df.format(discount.multiply(BigDecimal.TEN)) + "折";
        }
        return tip;
    }
}
