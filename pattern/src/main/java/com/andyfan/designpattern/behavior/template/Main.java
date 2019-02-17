package com.andyfan.designpattern.behavior.template;

/**
 * @author andyFan
 * @since 2019年02月06日
 */
public class Main {

    public static void main(String[] args) {
        Dish rice=new CookeRice();
        rice.doDish();
        System.out.println("**************");
        Dish fish=new CookeFish();
        fish.doDish();
    }
}
