package pers.xf.learn.designpattern.visitorpattern;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<IElement> list = new ArrayList<>();

    {
        this.list.add(new ConcreteElementA());
        this.list.add(new ConcreteElementB());
    }

    public void accept(IVisitor visitor){
        for (IElement element : list){
            element.accept(visitor);
        }
    }
}
