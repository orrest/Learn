package pers.xf.learn.designpattern.facadepattern;

public class Test {
    public static void main(String[] args) {
        Facade facade  = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();


        /**
         * 不适用门面模式时
         * 需要自行处理各子系统细节
         */
//        SubsystemA a = new SubsystemA();
//        SubsystemB b = new SubsystemB();
//        SubsystemC c = new SubsystemC();
//
//        a.request();
//        b.execute();
//        c.callForResult();
    }
}
