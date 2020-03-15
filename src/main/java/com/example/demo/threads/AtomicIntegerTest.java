package com.example.demo.threads;

import java.util.concurrent.atomic.AtomicInteger;
public class AtomicIntegerTest {
    public static void main(String[] args) {
        /**
         * AtomicIntegerTest  线程安全
         */
        int i = 0;
        AtomicInteger atomicInteger = new AtomicInteger(i);
        //相当于   ++i
        i = atomicInteger.incrementAndGet();
        System.out.println(i);
        //相当于  i++
        i = atomicInteger.getAndIncrement();
        System.out.println(i);
    }
}