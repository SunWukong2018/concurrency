package com.fly.concurrency.example.syncContainer;

import java.util.Iterator;
import java.util.Vector;

import com.fly.concurrency.annoations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * 同步容器 
 * @author ERIC 2018年4月24日 下午5:32:24
 */
@Slf4j
@NotThreadSafe
public class VectorExample3 {

    private static void test1(Vector<Integer> v) {
        for (Integer i : v) {
            if (i.equals(3)) {
                v.remove(i);
            }
        }
    }

    private static void test2(Vector<Integer> v) {
        Iterator<Integer> it = v.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i.equals(3)) {
                v.remove(i);
            }
        }
    }

    private static void test3(Vector<Integer> v) {
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).equals(3)) {
                v.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(3);
        test3(v);
        //遍历的时候不要做删除操作 建议循环时做好标记 循环完再删除
    }
}
