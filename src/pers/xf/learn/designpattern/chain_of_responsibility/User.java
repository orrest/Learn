package pers.xf.learn.designpattern.chain_of_responsibility;

/**
 * Represent a user.
 */
public class User {
    public int level;
    public final int VIP = 0;
    public final int NORMAL = 1;

    public String getLoginName() {
        return "SomeName";
    }

    public String getLoginPass() {
        return "SomePassword";
    }

    public void setPermission(int level){
        this.level = level;
    }
}
