package com.fly.concurrency.example.singleton;

import com.fly.concurrency.annoations.ThreadSafe;

/**
 * 单例实例 饿汉模式 线程安全 
 * 如果私有构造函数没有过多的处理并且实例化的过程中肯定会被使用比较推荐使用饿汉模式
 * 
 * @author ERIC 2018年4月23日 上午9:44:13
 */
@ThreadSafe
public class SingletonExample6 {

    // 私有构造方法 如果想写单例就不能让外部类通过new的方式获取对象
    private SingletonExample6(){

    }
    // 单例对象
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    // 静态工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());

        System.out.println(getInstance());

        System.out.println(getInstance());
    }
}
