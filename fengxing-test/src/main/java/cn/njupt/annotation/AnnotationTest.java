package cn.njupt.annotation;

import com.alibaba.fastjson.JSONObject;

import java.lang.annotation.Annotation;

/**
 * Created by sunfei on 2018/1/24.
 */
public class AnnotationTest {

    public static void main(String[] args) throws Exception {
        Class<Apple> appleClass = Apple.class;
        MyAnnotation annotation = appleClass.getAnnotation(MyAnnotation.class);
        Apple apple = appleClass.newInstance();
        apple.setAge(annotation.age());
        apple.setName(annotation.name());

        System.out.println(JSONObject.toJSONString(apple));

    }
}
