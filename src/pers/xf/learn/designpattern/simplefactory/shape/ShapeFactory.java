package pers.xf.learn.designpattern.simplefactory.shape;

import java.lang.reflect.InvocationTargetException;

public class ShapeFactory {
    private IShape createShape(Class<? extends IShape> shape){
        if (null != shape){
            try {
                return shape.getDeclaredConstructor().newInstance();
            } catch (InstantiationException
                    | IllegalAccessException
                    | InvocationTargetException
                    | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public IShape createShape(String name){
        if (name == null || name.equals("")){
            return null;
        }
        switch (name.toLowerCase()){
            case "circle":
                return createShape(Circle.class);
            case "rectangle":
                return createShape(Rectangle.class);
            case "square":
                return createShape(Square.class);
            default:
                return null;
        }
    }
}
