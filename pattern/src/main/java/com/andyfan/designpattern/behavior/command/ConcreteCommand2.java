package com.andyfan.designpattern.behavior.command;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public class ConcreteCommand2 extends Command {
    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doSomething();
    }

}
