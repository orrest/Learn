package pers.xf.learn.designpattern.chain_of_responsibility.loginprocess;

import pers.xf.learn.designpattern.chain_of_responsibility.User;

public class AuthHandler extends Handler{
    @Override
    public void doHandle(User user) {
        if (user.VIP != user.level){
            System.out.println("Not VIP user!");
            return;
        }
        System.out.println("Do something that VIP could do!");
    }
}
