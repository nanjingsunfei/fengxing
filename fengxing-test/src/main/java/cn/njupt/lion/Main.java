package cn.njupt.lion;

import com.dianping.lion.client.Lion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sunfei on 2017/12`/4.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/appcontext-lion.xml");

        String property = Lion.get("orderdish-wxm-web.operate.degradeswitch.loginlist");
        System.out.println(property);

        LionCat lionCat = applicationContext.getBean(LionCat.class);
        lionCat.print();


        System.exit(0);


    }
}
