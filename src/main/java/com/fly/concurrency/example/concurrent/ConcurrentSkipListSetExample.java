package com.fly.concurrency.example.concurrent;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.fly.concurrency.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ConcurrentSkipListSetExample{

    private static int          clientTotal = 5000;                       // 请求总数

    private static int          threadTotal = 200;                        // 同时并发执行线程数

    private static Set<Integer> set        = new ConcurrentSkipListSet<>();

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);// 定义信号量
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);// 计数器值设为5000
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();// 释放信号量
                } catch (Exception e) {
                    log.error("exception:{}", e);
                }
                countDownLatch.countDown();// 计数器值运行一次减1
            });
        }
        countDownLatch.await();// 保证计数器值减为0
        exec.shutdown();// 关闭线程池
        log.info("size:{}", set.size());
    }

    static void add(final int i) {
        set.add(i);
    }

}
