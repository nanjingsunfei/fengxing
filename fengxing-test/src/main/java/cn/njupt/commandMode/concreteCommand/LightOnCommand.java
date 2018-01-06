package cn.njupt.commandMode.concreteCommand;

import cn.njupt.commandMode.receiver.Light;
import cn.njupt.commandMode.command.Command;

/**
 * Created by sunfei on 2017/12/3.
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {

    }
}
