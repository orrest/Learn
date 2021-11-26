package pers.xf.learn.designpattern.templatemethodpattern;

public class SortAlgorithmB extends SortAlgorithmTestTemplate {
    @Override
    protected void sorting() {
        super.sorting();
        System.out.println("Sorting algorithm A, sorting...");
    }
}
