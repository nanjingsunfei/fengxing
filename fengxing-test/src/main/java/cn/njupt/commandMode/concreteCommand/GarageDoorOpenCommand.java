package cn.njupt.commandMode.concreteCommand;

import cn.njupt.commandMode.command.Command;
import cn.njupt.commandMode.receiver.GarageDoor;

/**
 * Created by sunfei on 2017/12/3.
 */
public class GarageDoorOpenCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.up();
    }

    public void undo() {

    }
}
