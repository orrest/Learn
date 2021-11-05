package pers.xf.learn.designpattern.chain_of_responsibility.loginprocess;

import pers.xf.learn.designpattern.chain_of_responsibility.User;

/**
 * Handle login step.
 */
public class LoginHandler extends Handler {
    @Override
    public void doHandle(User user) {
        System.out.println("Logged in!");
        user.setPermission(user.VIP);
        chain.doHandle(user);
    }
}
