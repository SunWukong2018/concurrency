package com.fly.concurrency.example.immutable;

import java.util.Map;

import com.fly.concurrency.annoations.NotThreadSafe;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class ImmutableExample {

    private final static Integer             a   = 1;
    private final static String              b   = "2";
    private final static Map<String, Object> map = Maps.newHashMap();//final修饰引用类型  一旦赋值后不能引用另外一个对象 但对象里的值可以修改

    static {
        map.put("1", 2);
        map.put("3", 4);
        map.put("5", 6);
    }

    public static void main(String[] args) {
        map.put("1", 3);
        log.info("{}", map.get("1"));
    }
}
