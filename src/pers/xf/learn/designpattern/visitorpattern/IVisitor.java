package pers.xf.learn.designpattern.visitorpattern;

public interface IVisitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}
