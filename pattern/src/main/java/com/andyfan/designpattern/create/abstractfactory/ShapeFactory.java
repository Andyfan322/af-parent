package com.andyfan.designpattern.create.abstractfactory;

import com.andyfan.designpattern.create.abstractfactory.color.Color;
import com.andyfan.designpattern.create.abstractfactory.shpae.Circle;
import com.andyfan.designpattern.create.abstractfactory.shpae.Rectangle;
import com.andyfan.designpattern.create.abstractfactory.shpae.Shape;
import com.andyfan.designpattern.create.abstractfactory.shpae.Square;

/**
 * @author andyFan
 * @since 2019年02月12日
 */
public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
