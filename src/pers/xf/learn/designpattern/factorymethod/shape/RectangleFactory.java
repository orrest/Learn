package pers.xf.learn.designpattern.factorymethod.shape;

public class RectangleFactory implements IShapeFactory {
    @Override
    public IShape createShape() {
        return new Rectangle();
    }
}
