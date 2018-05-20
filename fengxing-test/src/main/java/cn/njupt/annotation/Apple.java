package cn.njupt.annotation;

/**
 * Created by sunfei on 2018/1/24.
 */
@MyAnnotation(name = "Banano", age = 13)
public class Apple {
    private String name = "apple";

    private int age = 16;


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
}
