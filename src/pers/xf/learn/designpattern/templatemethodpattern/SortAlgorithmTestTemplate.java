package pers.xf.learn.designpattern.templatemethodpattern;

/**
 * 假设我们做一个排序算法测试的模板类.
 * 准备数据和排序完打印的流程都固定, 不需要子类重写
 */
public class SortAlgorithmTestTemplate {
    private void beforeSort(){
        System.out.println("---Prepare some data for sort---");
    }

    protected void sorting(){
        System.out.println("Sorting...");
    }

    private void afterSort(){
        System.out.println("---The sorted result---");
        System.out.println();
    }

    // 定义了使用流程.
    // 声明 final, 避免被子类重写
    public final void sortingTest(){
        this.beforeSort();
        this.sorting();
        this.afterSort();
    }
}
