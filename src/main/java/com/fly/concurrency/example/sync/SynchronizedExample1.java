package com.fly.concurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fly.concurrency.annoations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class SynchronizedExample1 {

    // 修饰代码块
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test{}-{}",j, i);
            }
        }
    }
    
    //修饰方法
    public synchronized void test2(){
        for (int i = 0; i < 10; i++) {
            log.info("test2-{}", i);
        }
    }
    
    public static void main(String[] args) {
        SynchronizedExample1 example1= new SynchronizedExample1();
        SynchronizedExample1 example2= new SynchronizedExample1();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(()->{
            example1.test1(1);
        });
        exec.execute(()->{
            example2.test1(2);
        });
    }

}
