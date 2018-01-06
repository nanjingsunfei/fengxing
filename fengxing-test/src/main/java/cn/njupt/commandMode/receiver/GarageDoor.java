package cn.njupt.commandMode.receiver;

/**
 * Created by sunfei on 2017/12/3.
 */
public class GarageDoor {
    private String name = "sunfei";

    public GarageDoor(String name) {
        if (name != null && name.length() != 0) {
            this.name = name;
        }
    }

    public void up() {
        System.out.println(name + "'s garage door is open");
    }

    public void down() {
        System.out.println(name + "'s' garage door is down");
    }

    public void stop() {
        System.out.println(name + "'s garage door is stop");
    }

    public void lightOn() {
        System.out.println(name + "'s garage door is lightOn");
    }

    public void lightOff() {
        System.out.println(name + "'s garage door is lightOff");
    }
}
