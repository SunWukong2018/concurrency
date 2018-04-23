package com.fly.concurrency.example.singleton;

import com.fly.concurrency.annoations.NotThreadSafe;

/**
 * 单例实例 懒汉模式 线程不安全
 * 在第一次使用时创建实例
 * 
 * @author ERIC 2018年4月23日 上午9:44:13
 */
@NotThreadSafe
public class SingletonExample {

    // 私有构造方法 如果想写单例就不能让外部类通过new的方式获取对象
    private SingletonExample(){

    }

    // 单例对象
    private static SingletonExample instance = null;

    // 静态工厂方法
    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }
}
