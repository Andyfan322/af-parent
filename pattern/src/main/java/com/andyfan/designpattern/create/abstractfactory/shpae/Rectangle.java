package com.andyfan.designpattern.create.abstractfactory.shpae;

/**
 * @author andyFan
 * @since 2019年02月12日
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("构造直角形");
    }
}
