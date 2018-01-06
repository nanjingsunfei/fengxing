package cn.njupt.commandMode.concreteCommand;

import cn.njupt.commandMode.command.Command;
import cn.njupt.commandMode.receiver.Stereo;

/**
 * Created by sunfei on 2017/12/3.
 */
public class StereoOffWithCDCommand implements Command {
    private Stereo stereo;

    public StereoOffWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.off();
    }

    public void undo() {

    }
}
