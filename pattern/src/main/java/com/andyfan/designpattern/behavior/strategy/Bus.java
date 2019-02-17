package com.andyfan.designpattern.behavior.strategy;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public class Bus implements GoToBeijing {

    /**
     * 坐汽车
     */
    @Override
    public void toBeijing() {
        System.out.println("go to beijing byBus");
    }
}
