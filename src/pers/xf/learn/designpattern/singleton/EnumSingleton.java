package pers.xf.learn.designpattern.singleton;

/**
 * Lazy:            false
 * Thread safe:     true
 */
public enum EnumSingleton {
    INSTANCE;

    /* Default private. */
    EnumSingleton(){
        System.out.println("Initializing INSTANCE");
    }

    /* Some functionality. */
    public void method(){
        System.out.println("EnumSingleton#method");
    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.method();
    }
}
