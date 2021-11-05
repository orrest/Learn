package pers.xf.learn.designpattern.chain_of_responsibility.loginprocess;

import pers.xf.learn.designpattern.chain_of_responsibility.User;

/**
 * Abc class for responsible chain.
 */
public abstract class Handler {
    protected Handler chain;

    public final void next (Handler handler){
        this.chain = handler;
    }

    public abstract void doHandle (User user);
}
