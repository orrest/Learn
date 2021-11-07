package pers.xf.learn.designpattern.factorymethod.shape;

public class SquareFactory implements IShapeFactory {
    @Override
    public IShape createShape() {
        return new Square();
    }
}
