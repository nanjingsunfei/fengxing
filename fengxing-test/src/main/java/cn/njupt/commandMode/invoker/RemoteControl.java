package cn.njupt.commandMode.invoker;

import cn.njupt.commandMode.command.Command;
import cn.njupt.commandMode.concreteCommand.NoCommand;

/**
 * Created by sunfei on 2017/12/3.
 */
public class RemoteControl {
    private Command[] onCommand;
    private Command[] offCommand;

    public RemoteControl() {
        onCommand = new Command[7];
        offCommand = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommand[i] = noCommand;
            offCommand[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommand[slot] = onCommand;
        this.offCommand[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommand[slot].execute();
    }

    public void offButtoenWasPressed(int slot) {
        offCommand[slot].execute();
    }
}
