package pers.xf.learn.designpattern.simplefactory;

import pers.xf.learn.designpattern.simplefactory.shape.Circle;
import pers.xf.learn.designpattern.simplefactory.shape.IShape;
import pers.xf.learn.designpattern.simplefactory.shape.ShapeFactory;

public class Test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        String shapeName = "Circle";
        IShape circle = shapeFactory.createShape(shapeName);
        circle.draw();

    }
}
