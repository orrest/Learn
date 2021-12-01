package pers.xf.learn.designpattern.statepattern;

public class VisitorState extends UserState {

    /**
     * VisitorState的favorite方法作用是:
     * 1. 跳转登录
     * 2. 调用登陆后的favorite方法
     */
    @Override
    public void favorite() {
        this.switch2Login();
        // 调用登陆后的favorite方法
        this.context.getState().favorite();
    }

    /**
     * VisitorState的comment方法作用是:
     * 1. 跳转登录
     * 2. 调用登陆后的comment方法
     */
    @Override
    public void comment(String comment) {
        this.switch2Login();
        // 调用登陆后的comment方法
        this.context.getState().comment(comment);
    }

    private void switch2Login() {
        System.out.println("跳转到登陆页面");
        System.out.println("登陆中...");
        this.context.setState(Context.STATE_LOGIN);
    }
}
