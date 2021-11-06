package pers.xf.learn.designpattern.simplefactory.shape;

import pers.xf.learn.designpattern.simplefactory.shape.IShape;

public class Rectangle implements IShape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle!");
    }
}
