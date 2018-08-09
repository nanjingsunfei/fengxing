package cn.njupt.fengxing.spring;

import cn.njupt.fengxing.spring.beans.Cat;
import cn.njupt.fengxing.spring.beans.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by sunfei on 2017/9/23.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring/appcontext.xml");

        applicationContext.getBean("dog");


//        Dog dog = (Dog) applicationContext.getBean("dog");
//        System.out.println(dog.getClass().getName());
//        dog.init();

//        People people = (People) applicationContext.getBean("people");
//        System.out.println(people.getClass().getName());
//        people.pet();
//
//        ApplicationContext applicationContext1 =  new AnnotationConfigApplicationContext();
//        applicationContext1.getBean("dog");

    }
}
