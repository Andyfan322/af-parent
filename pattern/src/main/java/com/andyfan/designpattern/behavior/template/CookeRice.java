package com.andyfan.designpattern.behavior.template;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public class CookeRice extends Dish {
    @Override
    void prepare() {
        System.out.println("准备淘米...");
    }

    @Override
    void cooke() {
        System.out.println("蒸米饭...");
    }
}
