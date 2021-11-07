package pers.xf.learn.designpattern.factorymethod.shape;

public class Square implements IShape{
    public Square(){
        System.out.println("Initializing a Square");
    }

    @Override
    public void draw() {
        System.out.println("Square created!");
    }
}
