package pers.xf.learn.designpattern.delegatepattern;

public class ConcreteB implements ITask{
    @Override
    public void doTask() {
        System.out.println("B doing task ...");
    }
}
