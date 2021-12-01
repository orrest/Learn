package pers.xf.learn.designpattern.statepattern;

public abstract class UserState {
    protected Context context;

    public void setContext(Context context){
        this.context = context;
    }

    public abstract void favorite();
    public abstract void comment(String comment);
}
