package pers.xf.learn.designpattern.simplefactory;

import pers.xf.learn.designpattern.simplefactory.shape.Circle;
import pers.xf.learn.designpattern.simplefactory.shape.IShape;
import pers.xf.learn.designpattern.simplefactory.shape.ShapeFactory;

public class Test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();



        IShape circle = shapeFactory.createShape(Circle.class);
        circle.draw();


    }
}
