package pers.xf.learn.jlang.multithread.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *
 *
 *
 */
public class CallableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = ()->{
            return 5;
        };
        FutureTask<Integer> futureTask = new FutureTask<>(task);

        new Thread(futureTask).start();

        Integer end = futureTask.get();
        System.out.println("The 5: " + end);
    }

}
