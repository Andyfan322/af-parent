package com.andyfan.designpattern.create.factory;

/**
 * @author andyFan
 * @since 2019年03月10日
 */
public class Main {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();
        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();
        Shape square = ShapeFactory.getShape("SQUARE");
        square.draw();
    }
}
