package cn.njupt.thread.join;

/**
 * Created by sunfei on 2018/5/14.
 */
public class Worker implements Runnable {
    //工作者名
    private String name;
    //工作时间
    private long time;

    public Worker(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {

        try {
            System.out.println(name+"开始工作");
            Thread.sleep(time);
            System.out.println(name+"工作完成，耗费时间="+time);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Worker("线程1", 2000));
        Thread t2 = new Thread(new Worker("线程2", 4000));
        Thread t3 = new Thread(new Worker("线程3", 1000));

        t1.start();
        t2.start();

        t1.join();
        System.out.println("线程1执行完成");
        t2.join();

        t3.start();
    }
}
