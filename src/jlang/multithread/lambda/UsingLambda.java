package jlang.multithread.lambda;

import java.util.function.IntConsumer;

public class UsingLambda {
    public static void repeat(int n, Runnable action){
        for (int i = 0; i < n; i++) action.run();
    }

    public static void repeat(int n, IntConsumer action){
        for (int i = 0; i < n; i++) action.accept(i); // Performs this operation on the given argument.
    }

    public static void main(String[] args) {
        repeat(10, (x) -> System.out.println(x));   // lambda ==> action
    }
}
