package com.example.demo.locks;

import org.openjdk.jol.info.ClassLayout;

public class HeavyLockDemo {
    static DemoTest demoTest;
 
 
    public static void main(String[] args) throws InterruptedException {
        demoTest = new DemoTest();
        System.out.println("befor lock");
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());
 
 
        Thread t1 = new Thread(()-> {
            synchronized (demoTest) {
                try {
                    Thread.sleep(5000);
                    System.out.println("t1 done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
 
        t1.start();
        System.out.println("t1 lock ing");
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());
 
 
        sysn();

        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());
 
 
        System.gc();
        System.out.println("after gc");
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());
 
    }
 
 
    public static void sysn() throws InterruptedException {
        synchronized (demoTest) {
            System.out.println("main lock ing");
            System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());
        }

        Thread.sleep(5000);
    }
 
}