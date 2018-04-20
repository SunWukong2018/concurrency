package com.fly.concurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fly.concurrency.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class SynchronizedExample2 {

    // 修饰一个类
    public  static void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test{}-{}",j, i);
            }
        }
    }
    
    //修饰静态方法
    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test{}-{}",j, i);
        }
    }
    
    public static void main(String[] args) {
        SynchronizedExample2 example1= new SynchronizedExample2();
        SynchronizedExample2 example2= new SynchronizedExample2();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(()->{
            example1.test1(1);
        });
        exec.execute(()->{
            example2.test1(2);
        });
    }

}
