package pers.xf.learn.jlang.multithread.synchronize;

import java.util.concurrent.atomic.AtomicLong;

public class Atomics {
    AtomicLong nextNumber = new AtomicLong();
    long id = nextNumber.incrementAndGet();
}
