package com.andyfan.designpattern.behavior.template;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public abstract class Dish {
    /**
     * 点菜
     */
    abstract void prepare();

    /**
     * 烧菜
     */
    abstract void cooke();

    /**
     * 吃
     */
    protected void doDish() {
        prepare();
        cooke();
    }
}
