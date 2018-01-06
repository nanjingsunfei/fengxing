package cn.njupt.commandMode.receiver;

/**
 * Created by sunfei on 2017/12/3.
 */
public class Stereo {
    private String name;

    public Stereo(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + "'s stereo is on");
    }

    public void off() {
        System.out.println(name + "'s stereo is off");
    }

    public void setCd() {
        name = "cd: " + name;
    }

    public void setDvd() {
        name = "dvd: " + name;
    }

    public void setVideo() {
        name = "video: " + name;
    }

    public void setVolume(int volume) {
        System.out.println(name + "'s volume is " + volume);
    }
}
