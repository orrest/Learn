package pers.xf.learn.jlang.multithread.synchronize;

import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock transfer method, so there won't be two threads
 * function it at the same time.
 */
public class Bank {
    private final double[] accounts;




    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException{
            while (accounts[from] < amount){
                wait();
            }

            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d\t", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance: %10.2f\n", getTotalBalance());

            notifyAll();
    }

    public synchronized double getTotalBalance(){
        double sum = 0;
        for(double a : accounts){
            sum += a;
        }
        return sum;
    }

    public int size(){return accounts.length;}
}
