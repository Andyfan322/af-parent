package com.andyfan.designpattern.behavior.strategy;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public class StrategyContext {

    private GoToBeijing toBeijing;

    public StrategyContext(GoToBeijing toBeijing) {
        this.toBeijing = toBeijing;
    }

    public void toBeijing() {
        toBeijing.toBeijing();
    }
}
