package pers.xf.learn.designpattern.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class WindowContainer extends ConfigurationContainer  {
    protected List<WindowContainer> mChildren = new ArrayList<>();
}
