package pers.xf.learn.designpattern.visitorpattern;

public class ConcreteElementA implements IElement {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String operationA(){
        return this.getClass().getSimpleName();
    }
}
