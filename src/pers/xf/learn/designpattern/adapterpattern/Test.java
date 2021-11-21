package pers.xf.learn.designpattern.adapterpattern;

public class Test {
    public static void main(String[] args) {
        IDC5V adapter = new PowerAdapter();
        int res = adapter.outputDC5V();
        System.out.println("Finally we got " + res);
    }
}
