package cn.njupt.classloader;

import java.io.Serializable;

/**
 * Created by sunfei on 2018/3/21.
 */
public class Loader implements Serializable {
    private String name = "test";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
