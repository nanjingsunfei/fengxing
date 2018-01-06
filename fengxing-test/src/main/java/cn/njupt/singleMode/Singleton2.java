package cn.njupt.singleMode;

/**
 * Created by sunfei on 2017/11/27.
 */
public class Singleton2 {
    private static Singleton2 uniqueInstance = new Singleton2();

    private Singleton2() {}

    public Singleton2 getIntance() {
        return uniqueInstance;
    }
}
