package cn.njupt.rhino;

import com.dianping.rhino.annotation.Degrade;
import com.dianping.rhino.annotation.Rhino;

import java.util.Random;

/**
 * Created by sunfei on 2017/12/4.
 */
@Rhino
public class ProductServiceImpl implements ProductService{
    Random random = new Random();

    @Degrade(rhinoKey = "getPrice", fallBackMethod = "fallBack", errorThresholdPercentage = 1, sleepWindowInMilliseconds = 5)
    public int getPrice() {
        int n = random.nextInt(1000);
//        System.out.println(n);
        int m = 1;
        if (n > 990) {
            m = 1 / 0;
        }
        return m;
    }

    public int fallBack() {
        System.out.println("走了降级");
        return 0;
    }

}
