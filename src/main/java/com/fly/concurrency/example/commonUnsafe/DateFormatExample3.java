package com.fly.concurrency.example.commonUnsafe;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fly.concurrency.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class DateFormatExample3 {

    public static DateTimeFormatter dtf         = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    private static int              clientTotal = 5000;                                            // 请求总数

    private static int              threadTotal = 200;                                             // 同时并发执行线程数

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);// 定义信号量
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);// 计数器值设为5000
        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();// 释放信号量
                } catch (Exception e) {
                    log.error("exception:{}", e);
                }
                countDownLatch.countDown();// 计数器值运行一次减1
            });
        }
        countDownLatch.await();// 保证计数器值减为0
        exec.shutdown();// 关闭线程池
    }

    static void update() {
        Date date = DateTime.parse("2018-04-24 13:01:01", dtf).toDate();
        log.error("time:{}", date);
    }
}
