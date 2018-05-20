package cn.njupt.classloader;

import java.io.Serializable;

/**
 * Created by sunfei on 2018/3/21.
 */
public class Test {

    public static void main(String[] args) {
//        try {
//            ClassLoader classLoader = Serializable.class.getClassLoader();
//
//            System.out.println(classLoader.toString());
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            ClassLoader classLoader1 = Loader.class.getClassLoader();
//
//            System.out.println(classLoader1.toString());
//        }catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println(ATest.class.getClassLoader());


    }
}
