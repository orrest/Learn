package pers.xf.learn.designpattern.factorymethod.shape;

public class CircleFactory implements IShapeFactory {
    @Override
    public IShape createShape() {
        return new Circle();
    }
}
