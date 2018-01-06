package cn.njupt.commandMode.receiver;

/**
 * Created by sunfei on 2017/12/3.
 */
public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    private String name;
    private int speed;
    private int preSpeed;

    public CeilingFan(String name) {
        this.name = name;
    }

    public void high() {
        preSpeed = speed;
        speed = HIGH;
        System.out.println(name + "'s speed is " + speed);
    }

    public void medium() {
        preSpeed = speed;
        speed = MEDIUM;
        System.out.println(name + "'s speed is " + speed);
    }

    public void low() {
        preSpeed = speed;
        speed = LOW;
        System.out.println(name + "'s speed is " + speed);
    }

    public void off() {
        preSpeed = speed;
        speed = OFF;
        System.out.println(name + "'s speed is " + speed);
    }

    public int getPreSpeed() {
        return preSpeed;
    }

}
