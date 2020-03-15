package com.example.demo.locks;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁：-XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
 */
public class BiasedLockDemo {
    static TestDemo demoTest = new TestDemo();

    public static void main(String[] args) throws InterruptedException {

      // Thread.sleep(6000);

        //hash计算？
       // demoTest.hashCode();

        System.out.println("befor lock");
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());


        //加锁
        sysn();

        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());
    }


    public static void sysn() {
        synchronized (demoTest) {
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());
        }
    }
}