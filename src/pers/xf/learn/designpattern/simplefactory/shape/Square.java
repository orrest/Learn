package pers.xf.learn.designpattern.simplefactory.shape;

public class Square implements IShape{
    @Override
    public void draw() {
        System.out.println("Drawing Square!");
    }
}
