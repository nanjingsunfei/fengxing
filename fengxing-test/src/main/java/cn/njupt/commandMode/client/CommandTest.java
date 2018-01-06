package cn.njupt.commandMode.client;

import cn.njupt.commandMode.concreteCommand.GarageDoorOpenCommand;
import cn.njupt.commandMode.concreteCommand.LightOnCommand;
import cn.njupt.commandMode.command.Command;
import cn.njupt.commandMode.invoker.SimpleRemoteControl;
import cn.njupt.commandMode.receiver.GarageDoor;
import cn.njupt.commandMode.receiver.Light;

/**
 * Created by sunfei on 2017/12/3.
 */
public class CommandTest {

    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        Light light = new Light("花灯");
        Command lightOnCommand = new LightOnCommand(light);

        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();

        GarageDoor garageDoor = new GarageDoor("");
        Command garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);

        simpleRemoteControl.setCommand(garageDoorOpenCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}
