package com.fly.concurrency.example.singleton;

import com.fly.concurrency.annoations.ThreadSafe;

/**
 * 双重同步锁单例模式 线程安全
 * 
 * @author ERIC 2018年4月23日 上午9:44:13
 */
@ThreadSafe
public class SingletonExample5 {

    // 私有构造方法 如果想写单例就不能让外部类通过new的方式获取对象
    private SingletonExample5(){

    }
 
    // 单例对象  volatile+双重检测机制禁止指令重排
    private static volatile SingletonExample5 instance = null;

    // 静态工厂方法
    public static synchronized SingletonExample5 getInstance() {
        if (instance == null) {// 双重检测机制
            synchronized (SingletonExample5.class) {// 同步锁
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
