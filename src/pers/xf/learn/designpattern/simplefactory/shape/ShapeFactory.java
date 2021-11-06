package pers.xf.learn.designpattern.simplefactory.shape;

import java.lang.reflect.InvocationTargetException;

public class ShapeFactory {
    public IShape createShape(Class<? extends IShape> shape){
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
}
