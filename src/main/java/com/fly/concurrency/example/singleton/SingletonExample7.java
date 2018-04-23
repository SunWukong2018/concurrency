package com.fly.concurrency.example.singleton;

import com.fly.concurrency.annoations.Recommend;
import com.fly.concurrency.annoations.ThreadSafe;

/**
 * 单例模式 枚举单例实例
 * 
 * 优点 
 * 相比懒汉模式 在安全性更容易保证
 * 相比饿汉模式 在实际调用时初始化实例并且保证在后续使用可以直接获取到实例 不会造成资源的浪费
 * @author ERIC 2018年4月23日 上午10:39:16
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    // 私有构造方法
    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
                            INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证此构造方法绝对只被调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
