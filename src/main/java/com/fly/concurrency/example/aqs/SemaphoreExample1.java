package com.fly.concurrency.example.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SemaphoreExample1 {

    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int count = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(3);//获取信号量许可
                    test(count);
                    semaphore.release(3);//释放许可
                } catch (Exception e) {
                    log.error("exception:{}", e);
                }
            });
        }
        exec.shutdown();//关闭线程池

    }

    static void test(int threadNum) throws Exception {
      
        log.info("线程号：{}", threadNum);
        Thread.sleep(1200);
    }
}
