package com.fly.concurrency.example.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import com.fly.concurrency.annoations.ThreadSafe;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class AtomicExample2 {

    private static AtomicIntegerFieldUpdater<AtomicExample2> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample2.class,
                                                                                                            "count");

    @Getter
    private volatile int                                     count   = 100;

    public static void main(String[] args) {
        AtomicExample2 atomicExample2 = new AtomicExample2();
        if (updater.compareAndSet(atomicExample2, 100, 120)) {
            log.info("update success 1,{}", atomicExample2.getCount());
        }

        if (updater.compareAndSet(atomicExample2, 100, 120)) {
            log.info("update success 2,{}", atomicExample2.getCount());
        } else {
            log.info("update failed,{}", atomicExample2.getCount());
        }
    }

}
