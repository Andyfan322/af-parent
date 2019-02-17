package com.andyfan.designpattern.behavior.strategy;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public class Fly implements GoToBeijing {

    /**
     * 坐飞机
     */
    @Override
    public void toBeijing() {
        System.out.println("go to beijing take a plane");
    }
}
