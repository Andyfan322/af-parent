package com.andyfan.designpattern.behavior.command;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
