package pers.xf.learn.designpattern.factorymethod.shape;

public class Rectangle implements IShape {
    public Rectangle(){
        System.out.println("Initializing a Rectangle");
    }

    @Override
    public void draw() {
        System.out.println("Rectangle created!");
    }
}
