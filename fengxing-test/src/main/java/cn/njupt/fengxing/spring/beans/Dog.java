package cn.njupt.fengxing.spring.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by sunfei on 2017/9/23.
 */
@Component
public class Dog {
    private String name = "木木";
    private int age = 12;
    private String food = "骨头";

    public Dog() {
        System.out.println("I am a dog!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @PostConstruct
    public void init() {
        System.out.println("init dog");
    }

    @Override
    public String toString() {
        return "name : " + name + ", age : " + age + ", food : " + food;
    }
}
