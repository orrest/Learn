package pers.xf.learn.designpattern.observerpattern;

public class Mouse extends EventContext {
    public void click(){
        System.out.println();
        System.out.println("Click happened,");
        System.out.println("Inform listener.");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void doubleClick(){
        System.out.println();
        System.out.println("DoubleClick happened,");
        System.out.println("Inform listener.");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }
}
