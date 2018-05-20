package cn.njupt.enumTest;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

import static cn.njupt.enumTest.Person.MAN;
import static cn.njupt.enumTest.Person.WOMAN;

/**
 * Created by sunfei on 2018/3/18.
 */
public class Test {

    public static void main(String[] args) {
        String name = "男";
        Person person = Person.getPersonByName(name);
        switch (person) {
            case MAN :
                System.out.println(MAN.getName());
                break;
            case WOMAN:
                System.out.println(WOMAN.getName());
                break;
            default:
                System.out.println("null");
        }


        List<String> list = Lists.newArrayList("1", "2");
        List<Integer> list1 = Arrays.asList(1, 2);

    }
}
