package cn.njupt.commandMode.receiver;

/**
 * Created by sunfei on 2017/12/3.
 */
public class Light {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + "'s light is on");
    }

    public void off() {
        System.out.println(name + "'s light is off");
    }

}
