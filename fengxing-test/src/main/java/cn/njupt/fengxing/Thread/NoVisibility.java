package cn.njupt.fengxing.Thread;

/**
 * Created by sunfei on 2017/10/12.
 */
public class NoVisibility {
    public static void main(String[] args) {
        ReaderThread t = new ReaderThread();
        t.start();
        while (true) {
            if (t.isFlag()) {
                System.out.println("--end break--");
                break;
            }
        }
    }
}

class ReaderThread extends Thread {
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + flag);
    }
}
