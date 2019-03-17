package com.andyfan.designpattern.create.factory;

/**
 * @author andyFan
 * @since 2019年02月12日
 */
public class ShapeFactory {

    public static Shape getShape(String shapeType) {

        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
