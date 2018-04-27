package com.fly.concurrency.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountDownLatchExample2 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int count = i;
         
            exec.execute(() -> {
                try {
               
                    test(count);
                } catch (Exception e) {
                    log.error("exception:{}", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(10,TimeUnit.MILLISECONDS);
        log.info("finsh");
        exec.shutdown();//关闭线程池

    }

    static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("线程号：{}", threadNum);
    }
}
