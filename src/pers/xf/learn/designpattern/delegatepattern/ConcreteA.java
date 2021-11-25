package pers.xf.learn.designpattern.delegatepattern;

public class ConcreteA implements ITask {
    @Override
    public void doTask() {
        System.out.println("A doing task ...");
    }
}
