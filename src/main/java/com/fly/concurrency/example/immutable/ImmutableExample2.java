package com.fly.concurrency.example.immutable;

import java.util.Collections;
import java.util.Map;

import com.fly.concurrency.annoations.ThreadSafe;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<String, Object> map = Maps.newHashMap();

    static {
        map.put("1", 2);
        map.put("3", 4);
        map.put("5", 6);
        map = Collections.unmodifiableMap(map);//不可变map 

    }

    public static void main(String[] args) {
        map.put("1", 3);//此操作会抛异常
        log.info("{}", map.get("1"));
    }
}
