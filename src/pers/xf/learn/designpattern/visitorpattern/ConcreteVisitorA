package pers.xf.learn.designpattern.visitorpattern;

/**
 * 为什么要弄两个Visitor, 并且在这两个Visitor的具体实现是一样的?
 * 在使用的时候区分角色, 大概是一种妥协的结果吧.
 */
public class ConcreteVisitorA implements IVisitor {
    @Override
    public void visit(ConcreteElementA element) {
        String result = element.operationA();
        System.out.println("result from "+element.getClass().getSimpleName() + ": " + result);
    }

    @Override
    public void visit(ConcreteElementB element) {
        int result = element.operationB();
        System.out.println("result from "+element.getClass().getSimpleName() + ": " + result);
    }
}
