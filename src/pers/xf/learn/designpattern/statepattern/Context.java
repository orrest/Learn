package pers.xf.learn.designpattern.statepattern;

public class Context {
    public static final UserState STATE_LOGIN = new LoginState();
    public static final UserState STATE_VISITOR = new VisitorState();
    private UserState currentState = STATE_VISITOR;

    // 提前设置context, 用于后面通知context改变currentState
    {
        STATE_LOGIN.setContext(this);
        STATE_VISITOR.setContext(this);
    }

    // State类调用, 通知context改变currentState
    public void setState(UserState state){
        this.currentState = state;
        this.currentState.setContext(this);
    }

    // VisitorState中改变状态后调用
    public UserState getState(){
        return this.currentState;
    }

    // 下面这两个方法如果State增加了方法则这里也需要增加, 不支持开闭原则.
    public void favorite(){
        this.currentState.favorite();
    }

    public void comment(String comment){
        this.currentState.comment(comment);
    }
}
