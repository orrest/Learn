package pers.xf.learn.designpattern.interpreterpattern;

/**
 * Only support +
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Result: " + new Calculator("10 + 30").calculate());
    }
}
