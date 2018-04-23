package com.fly.concurrency.example.singleton;

import com.fly.concurrency.annoations.NotThreadSafe;

/**
 * 双重同步锁单例模式
 *  线程不安全
 * 
 * @author ERIC 2018年4月23日 上午9:44:13
 */
@NotThreadSafe
public class SingletonExample4 {

    // 私有构造方法 如果想写单例就不能让外部类通过new的方式获取对象
    private SingletonExample4(){

    }

    // 单例对象
    private static SingletonExample4 instance = null;

    // 静态工厂方法
    public static synchronized SingletonExample4 getInstance() {
        if (instance == null) {// 双重检测机制
            synchronized (SingletonExample4.class) {// 同步锁
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
