package com.andyfan.designpattern.behavior.template;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public class CookeFish extends Dish{
    @Override
    void prepare() {
        System.out.println("准备鱼...");
    }

    @Override
    void cooke() {
        System.out.println("鱼红烧...");
    }
}
