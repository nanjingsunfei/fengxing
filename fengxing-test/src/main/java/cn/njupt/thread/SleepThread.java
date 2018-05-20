package cn.njupt.thread;

/**
 * Created by sunfei on 2018/4/9.
 */
public class SleepThread implements Runnable{

    private Service service;

    public SleepThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.mSleep();
    }
}
