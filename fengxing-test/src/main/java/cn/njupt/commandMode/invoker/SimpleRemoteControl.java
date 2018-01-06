package cn.njupt.commandMode.invoker;

import cn.njupt.commandMode.command.Command;

/**
 * Created by sunfei on 2017/12/3.
 */
public class SimpleRemoteControl {

    private Command command;

    public SimpleRemoteControl() {

    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonWasPressed() {
        command.execute();
    }
}
