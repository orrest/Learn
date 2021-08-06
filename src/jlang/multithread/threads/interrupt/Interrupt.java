package jlang.multithread.threads.interrupt;

/**
 * sleep的线程调用interrupt方法会产生异常。
 * java.lang.InterruptedException
 * 	at java.base/java.lang.Thread.sleep(Native Method)
 * 	...
 */
public class Interrupt {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t = new Thread(r);
        t.start();
        t.interrupt();
    }
}
