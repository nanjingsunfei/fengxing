package cn.njupt.commandMode.concreteCommand;

import cn.njupt.commandMode.command.Command;
import cn.njupt.commandMode.receiver.CeilingFan;

import static cn.njupt.commandMode.receiver.CeilingFan.HIGH;
import static cn.njupt.commandMode.receiver.CeilingFan.LOW;
import static cn.njupt.commandMode.receiver.CeilingFan.MEDIUM;
import static cn.njupt.commandMode.receiver.CeilingFan.OFF;

/**
 * Created by sunfei on 2017/12/3.
 */
public class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }


    public void execute() {
        ceilingFan.off();
    }

    public void undo() {
        int preSpeed = ceilingFan.getPreSpeed();
        switch (preSpeed) {
            case HIGH:
                ceilingFan.high();
                break;
            case MEDIUM:
                ceilingFan.medium();
                break;
            case LOW:
                ceilingFan.low();
                break;
            case OFF:
                ceilingFan.off();
                break;
        }
    }
}
