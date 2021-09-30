package jlang.jvm;

public class Clinit {
    public static void main(String[] args) {
        System.out.println(new Sub().B);
    }
}

class Parent {
    public  int A = 1;

    {
        A = 2;
    }
}
class Sub extends Parent {
    public int B = A;
}