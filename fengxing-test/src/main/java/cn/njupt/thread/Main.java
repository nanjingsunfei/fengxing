package cn.njupt.thread;

/**
 * Created by sunfei on 2018/4/9.
 */
public class Main {

    public static void main(String[] args) {
        Service service = new Service();

        Thread sleepThread = new Thread(new SleepThread(service));
//        Thread waitThread = new Thread(new WaitThread(service));

        sleepThread.start();
//        waitThread.start();
    }
}
