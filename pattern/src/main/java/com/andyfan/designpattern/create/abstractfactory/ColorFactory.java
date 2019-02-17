package com.andyfan.designpattern.create.abstractfactory;

import com.andyfan.designpattern.create.abstractfactory.color.Blue;
import com.andyfan.designpattern.create.abstractfactory.color.Color;
import com.andyfan.designpattern.create.abstractfactory.color.Green;
import com.andyfan.designpattern.create.abstractfactory.color.Red;
import com.andyfan.designpattern.create.abstractfactory.shpae.Shape;

/**
 * @author andyFan
 * @since 2019年02月12日
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }
}
