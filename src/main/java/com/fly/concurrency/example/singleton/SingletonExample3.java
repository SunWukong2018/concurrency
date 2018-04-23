package com.fly.concurrency.example.singleton;

import com.fly.concurrency.annoations.NotRecommend;
import com.fly.concurrency.annoations.ThreadSafe;

/**
 * 单例实例 懒汉模式 线程安全
 * 性能上的开销比较大
 * 
 * @author ERIC 2018年4月23日 上午9:44:13
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有构造方法 如果想写单例就不能让外部类通过new的方式获取对象
    private SingletonExample3(){

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态工厂方法
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
