package com.andyfan.designpattern.create.factory;

/**
 * @author andyFan
 * @since 2019年02月12日
 */
public class ShapeFactory {


    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();

        }
        return null;
    }
}
