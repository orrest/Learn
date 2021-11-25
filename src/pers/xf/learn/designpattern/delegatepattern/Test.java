package pers.xf.learn.designpattern.delegatepattern;

/**
 * 根据业务需求选择相应的具体实现类去完成.
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Delegate().doTask();
            System.out.println();
        }
    }
}
