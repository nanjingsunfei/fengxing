package cn.njupt.lion;

import com.dianping.lion.client.spring.LionConfig;
import org.springframework.stereotype.Component;

/**
 * Created by sunfei on 2017/12/15.
 */
@Component
public class LionCat {

    @LionConfig("orderdish-wxm-web.operate.degradeswitch.loginlist")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }
}
