package cn.njupt.commandMode.concreteCommand;

import cn.njupt.commandMode.command.Command;
import cn.njupt.commandMode.receiver.Stereo;

/**
 * Created by sunfei on 2017/12/3.
 */
public class StereoOnWithCDCommand implements Command {
    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.setCd();
        stereo.on();
        stereo.setVolume(11);
    }

    public void undo() {

    }
}
