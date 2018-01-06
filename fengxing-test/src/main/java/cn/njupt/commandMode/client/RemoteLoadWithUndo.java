package cn.njupt.commandMode.client;

import cn.njupt.commandMode.command.Command;
import cn.njupt.commandMode.concreteCommand.CeilingFanHighCommand;
import cn.njupt.commandMode.concreteCommand.CeilingFanOffCommand;
import cn.njupt.commandMode.invoker.RemoteControlWithUndo;
import cn.njupt.commandMode.receiver.CeilingFan;

/**
 * Created by sunfei on 2017/12/3.
 */
public class RemoteLoadWithUndo {

    public static void main(String[] args) {
        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();

        CeilingFan ceilingFan = new CeilingFan("living room");

        Command ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        Command ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remoteControlWithUndo.setCommand(0, ceilingFanHigh, ceilingFanOff);

        remoteControlWithUndo.onButtonWasPressed(0);
        remoteControlWithUndo.offButtoenWasPressed(0);

        remoteControlWithUndo.undoButtonWasPressed();
    }
}
