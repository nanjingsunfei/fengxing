package cn.njupt.fengxing.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sunfei on 2017/9/23.
 */
@Component("people")
public class PeopleImpl implements People{

    private String name = "小红";

    @Autowired
    private Dog dog;

    public void pet() {
        System.out.println(name + " love " + dog.getName());
    }

    public void init() {
        System.out.println("init people");
    }
}
