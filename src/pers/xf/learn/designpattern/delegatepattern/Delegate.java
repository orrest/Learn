package pers.xf.learn.designpattern.delegatepattern;

import java.util.Random;

public class Delegate implements ITask{
    @Override
    public void doTask() {
        System.out.println("---Doing task in delegate!---");

        // select a Concrete by some rules.
        ITask task = null;
        if (new Random().nextBoolean()){
            task = new ConcreteA();
        } else {
            task = new ConcreteB();
        }

        // do task
        task.doTask();

        System.out.println("---Task done by delegate.---");
    }
}
