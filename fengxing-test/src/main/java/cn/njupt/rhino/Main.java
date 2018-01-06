package cn.njupt.rhino;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sunfei on 2017/12/4.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/appcontext-rhino.xml");

        ProductService productService = applicationContext.getBean(ProductService.class);
        while(true) {
            try {
                int price = productService.getPrice();
            } catch (Exception e) {
            }
        }

    }
}
