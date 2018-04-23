package com.fly.concurrency.example.singleton;

import com.fly.concurrency.annoations.ThreadSafe;

/**
 * 单例实例 饿汉模式 线程安全 
 * 如果私有构造函数没有过多的处理并且实例化的过程中肯定会被使用比较推荐使用饿汉模式
 * 
 * @author ERIC 2018年4月23日 上午9:44:13
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造方法 如果想写单例就不能让外部类通过new的方式获取对象
    private SingletonExample2(){

    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
