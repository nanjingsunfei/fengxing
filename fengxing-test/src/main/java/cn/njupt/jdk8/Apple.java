package cn.njupt.jdk8;

import com.google.common.base.MoreObjects;

/**
 * Created by sunfei on 2018/1/13.
 */
public class Apple {

    private int id;

    private String name;

    private String desc;

    public Apple() {
    }

    public Apple(String name) {
        this.name = name;
    }

    public Apple(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("name", name).add("desc", desc).toString();
    }
}
