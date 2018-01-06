package cn.njupt.commandMode.invoker;

import cn.njupt.commandMode.command.Command;
import cn.njupt.commandMode.concreteCommand.NoCommand;

/**
 * Created by sunfei on 2017/12/3.
 */
public class RemoteControlWithUndo {
    private Command[] onCommand;
    private Command[] offCommand;
    private Command undoCommand;

    public RemoteControlWithUndo() {
        onCommand = new Command[7];
        offCommand = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommand[i] = noCommand;
            offCommand[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommand[slot] = onCommand;
        this.offCommand[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommand[slot].execute();
        undoCommand = onCommand[slot];
    }

    public void offButtoenWasPressed(int slot) {
        offCommand[slot].execute();
        undoCommand = offCommand[slot];
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }
}
