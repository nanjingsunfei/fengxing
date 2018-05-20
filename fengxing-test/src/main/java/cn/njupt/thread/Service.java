package cn.njupt.thread;

/**
 * Created by sunfei on 2018/4/9.
 */
public class Service {

    public void mSleep() {
        synchronized(this) {
            try {
                System.out.println(" Sleep. current Time is :" + System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println(" Sleep. current Time is :" + System.currentTimeMillis());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void mWait() {
        synchronized(this) {
            System.out.println(" Wait. current Time is :" + System.currentTimeMillis());
        }
    }
}
