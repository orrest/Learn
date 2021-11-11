package pers.xf.learn.designpattern.flyweight.injdk;

/**
 * JDK为何要这样做呢？因为-128～127的数据在int范围内是使用最频繁的，
 * 为了减少频繁创建对象带来的内存消耗，这里就用到了享元模式，以提高性能。
 */
public class FlyweightInInteger {
    public static void main(String[] args) {
//         static final Integer cache[];
        Integer a = Integer.valueOf(100);
        Integer b = 100;

        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println("a == b: "+ (a==b));
        System.out.println("c == d: "+ (c==d));
    }
}
