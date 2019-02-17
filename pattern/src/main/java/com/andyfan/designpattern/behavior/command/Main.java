package com.andyfan.designpattern.behavior.command;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public class Main {
    public static void main(String[] args){
        Receiver receiver = new Receiver1();
        Command command = new ConcreteCommand1(receiver);

        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.action();
    }
}
