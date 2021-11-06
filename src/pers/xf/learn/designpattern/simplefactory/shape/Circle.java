package pers.xf.learn.designpattern.simplefactory.shape;

public class Circle implements IShape{
    @Override
    public void draw() {
        System.out.println("Drawing Circle!");
    }
}
