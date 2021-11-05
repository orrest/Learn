package pers.xf.learn.jlang.multithread.threads.createthread;

public class RunnableThread {


    /**
     * main_thread.sleep(ONE_TIME), sub_thread.sleep(THREE_TIME)
     * <Sub_Thread> i = 0
     * [Main_Thread] i = 0
     * [Main_Thread] i = 1
     * [Main_Thread] i = 2
     * <Sub_Thread> i = 1
     * [Main_Thread] i = 3
     * [Main_Thread] i = 4
     * [Main_Thread] i = 5
     * <Sub_Thread> i = 2
     * [Main_Thread] i = 6
     * [Main_Thread] i = 7
     * [Main_Thread] i = 8
     * <Sub_Thread> i = 3
     * [Main_Thread] i = 9
     * 主线程休眠 1 单位时间，子线程休眠 3 单位时间，主线程执行是子线程执行时间的三倍。
     * 主线程休眠 1 单位时间，子线程休眠 1 单位时间，主线程与子线程执行时间大致相同。
     * @param args
     */
    public static void main(String[] args) {
        new Thread(()->{
            threadMethod("<Sub_Thread>", 5);
        }).start();

        threadMethod("[Main_Thread]", 1);
    }

    private static void threadMethod(String tname, int sleep){
        for(int i = 0; i < 100; i++){
            try {
                System.out.println(tname+" i = " + i);
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
