package pers.xf.learn.designpattern.factorymethod;

import pers.xf.learn.designpattern.factorymethod.shape.CircleFactory;
import pers.xf.learn.designpattern.factorymethod.shape.IShape;

public class Test {
    public static void main(String[] args) {
        IShape circle = new CircleFactory().createShape();
        circle.draw();
    }
}
