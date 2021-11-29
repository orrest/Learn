package pers.xf.learn.designpattern.iteratorpattern;

public class Test {
    public static void main(String[] args) {
        ConcreteCollection<Integer> c = new ConcreteCollection<>();
        c.add(8);
        c.add(1);
        c.add(0);
        c.add(9);
        c.add(7);
        c.add(5);
        Iterator<Integer> iterator = c.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
