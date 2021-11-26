package pers.xf.learn.designpattern.templatemethodpattern;

public class Test {
    public static void main(String[] args) {
        // 对排序算法A进行测试
        SortAlgorithmTestTemplate t = new SortAlgorithmA();
        t.sortingTest();

        // 对排序算法B进行测试
        SortAlgorithmTestTemplate tt = new SortAlgorithmB();
        tt.sortingTest();
    }
}
