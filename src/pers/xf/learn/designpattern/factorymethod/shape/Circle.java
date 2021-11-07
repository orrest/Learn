package pers.xf.learn.designpattern.factorymethod.shape;

public class Circle implements IShape{
    public Circle(){
        System.out.println("Initializing a Circle");
    }

    @Override
    public void draw() {
        System.out.println("Circle crated!");
    }
}
