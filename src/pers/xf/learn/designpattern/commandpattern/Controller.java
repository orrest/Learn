package pers.xf.learn.designpattern.commandpattern;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<IAction> actions = new ArrayList<>();

    public void addAction(IAction action){
        actions.add(action);
    }

    public void execute(IAction action){
        action.execute();
    }

    public void executeAll(){
        for (IAction action : actions){
            action.execute();
        }
        actions.clear();
    }
}
