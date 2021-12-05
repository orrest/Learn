package pers.xf.learn.designpattern.visitorpattern;

public interface IElement {
    void accept(IVisitor visitor);
}
