package pers.xf.learn.designpattern.facadepattern;

/**
 * 为了显示门面模式统一访问的能力,
 * 将子系统类的调用名称故意写的不整齐.
 */
public class Facade {
    private SubsystemA a = new SubsystemA();
    private SubsystemB b = new SubsystemB();
    private SubsystemC c = new SubsystemC();

    public void doA(){
        a.request();
    }

    public void doB(){
        b.execute();
    }

    public void doC(){
        c.callForResult();
    }
}
