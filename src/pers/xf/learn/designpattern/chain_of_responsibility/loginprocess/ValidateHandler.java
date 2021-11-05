package pers.xf.learn.designpattern.chain_of_responsibility.loginprocess;

import pers.xf.learn.designpattern.chain_of_responsibility.User;

/**
 * Validate not null.
 */
public class ValidateHandler extends Handler {
    @Override
    public void doHandle(User user) {
        if (user.getLoginName().equals("")
            || user.getLoginPass().equals("")){
            System.out.println("User name or password is empty.");
            return;
        }
        System.out.println("Validating pass");
        chain.doHandle(user);
    }
}
