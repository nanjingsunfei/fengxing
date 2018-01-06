package cn.njupt.commandMode.client;

import cn.njupt.commandMode.command.Command;
import cn.njupt.commandMode.concreteCommand.GarageDoorDownCommand;
import cn.njupt.commandMode.concreteCommand.GarageDoorUpCommand;
import cn.njupt.commandMode.concreteCommand.LightOffCommand;
import cn.njupt.commandMode.concreteCommand.LightOnCommand;
import cn.njupt.commandMode.concreteCommand.StereoOffWithCDCommand;
import cn.njupt.commandMode.concreteCommand.StereoOnWithCDCommand;
import cn.njupt.commandMode.invoker.RemoteControl;
import cn.njupt.commandMode.receiver.GarageDoor;
import cn.njupt.commandMode.receiver.Light;
import cn.njupt.commandMode.receiver.Stereo;

/**
 * Created by sunfei on 2017/12/3.
 */
public class RemoteLoad {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        GarageDoor garageDoor =new GarageDoor("");
        Stereo stereo = new Stereo("Living Room");

        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        Command garageDoorUp = new GarageDoorUpCommand(garageDoor);
        Command garageDoorDown = new GarageDoorDownCommand(garageDoor);

        Command stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        Command stereoOffWithCD = new StereoOffWithCDCommand(stereo);


        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, garageDoorUp, garageDoorDown);
        remoteControl.setCommand(3, stereoOnWithCD, stereoOffWithCD);

        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtoenWasPressed(0);
        remoteControl.onButtonWasPressed(1);
        remoteControl.offButtoenWasPressed(1);
        remoteControl.onButtonWasPressed(2);
        remoteControl.offButtoenWasPressed(2);
        remoteControl.onButtonWasPressed(3);
        remoteControl.offButtoenWasPressed(3);


    }
}
