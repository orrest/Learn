package pers.xf.learn.designpattern.observerpattern;

public class Test {
    public static void main(String[] args) {
        EventListener listener = new MouseEventListener();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, listener);
        mouse.addListener(MouseEventType.ON_DOUBLE_CLICK, listener);

        mouse.click();
        mouse.doubleClick();
    }
}
