package com.andyfan.designpattern.behavior.strategy;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public class Main {

    public static void main(String[] args) {

        StrategyContext context = new StrategyContext(new Bus());
        context.toBeijing();
        StrategyContext context2 = new StrategyContext(new Fly());
        context2.toBeijing();
    }

}
