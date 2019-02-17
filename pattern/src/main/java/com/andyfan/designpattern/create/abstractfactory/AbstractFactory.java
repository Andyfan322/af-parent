package com.andyfan.designpattern.create.abstractfactory;

import com.andyfan.designpattern.create.abstractfactory.color.Color;
import com.andyfan.designpattern.create.abstractfactory.shpae.Shape;

/**
 * @author andyFan
 * @since 2019年02月12日
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
