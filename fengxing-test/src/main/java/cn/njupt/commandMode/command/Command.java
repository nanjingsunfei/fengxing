package cn.njupt.commandMode.command;

/**
 * Created by sunfei on 2017/12/3.
 */
public interface Command {
    public void execute();

    public void undo();
}
