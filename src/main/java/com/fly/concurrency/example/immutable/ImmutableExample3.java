package com.fly.concurrency.example.immutable;


import com.fly.concurrency.annoations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private final static ImmutableList                list = ImmutableList.of(1, 2, 3);
    private final static ImmutableSet                 set  = ImmutableSet.copyOf(list);
    private final static ImmutableMap<Object, Object> map  = ImmutableMap.builder().put(1, "2").put(3, "4").build();

    public static void main(String[] args) {
        // list.add(4);
        // set.add(4);
        //map.put(5, "6");
        log.info("{}",map.get(1));
    }
}
