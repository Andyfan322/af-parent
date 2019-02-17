package com.andyfan.designpattern.create.abstractfactory.color;

/**
 * @author andyFan
 * @since 2019年02月12日
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("填充绿色");
    }
}
