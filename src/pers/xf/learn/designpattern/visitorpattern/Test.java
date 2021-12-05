package pers.xf.learn.designpattern.visitorpattern;

public class Test {
    public static void main(String[] args) {
        ObjectStructure collection = new ObjectStructure();

        System.out.println("ConcreteVisitor A handle elements: ");
        collection.accept(new ConcreteVisitorA());

        System.out.println("---");

        System.out.println("ConcreteVisitor B handle elements: ");
        collection.accept(new ConcreteVisitorB());
    }
}
