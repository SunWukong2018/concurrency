package com.fly.concurrency.example.count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.fly.concurrency.annoations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class ConcurrencyExample4 {

    private static int          clientTotal = 5000; // 请求总数

    private static int          threadTotal = 200;  // 同时并发执行线程数

    private static volatile int count       = 0;//volatile 只适用于 先写后读 

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);// 定义信号量
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);// 计数器值设为5000
        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();// 释放信号量
                } catch (Exception e) {
                    log.error("exception:{}", e);
                }
                countDownLatch.countDown();// 计数器值运行一次减1
            });
        }
        countDownLatch.await();// 保证计数器值减为0
        exec.shutdown();// 关闭线程池
        log.info("count:{}", count);
    }

    private static void add() {
        count++;
    }

}
