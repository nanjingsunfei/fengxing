package cn.njupt.thread;

/**
 * Created by sunfei on 2018/4/9.
 */
public class WaitThread implements Runnable {

    private Service service;

    public WaitThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.mWait();
    }
}
