package pers.xf.learn.designpattern.compositepattern;

public class RootWindowContainer extends WindowContainer{
    public RootWindowContainer(WindowContainer w) {
        mChildren.add(w);
    }
}
