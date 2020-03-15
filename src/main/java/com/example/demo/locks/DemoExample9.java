package com.example.demo.locks;

import org.openjdk.jol.info.ClassLayout;

public class DemoExample9 {
    public static void main(String[] args) throws Exception {
        TestDemo testDemo = new TestDemo();

        //子线程
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (testDemo) {
                    System.out.println("t1 lock ing");
                    System.out.println(ClassLayout.parseInstance(testDemo).toPrintable());
                }
            }
        };
        t1.start();
        t1.join();

        //主线程
        synchronized (testDemo) {
            System.out.println("main lock ing");
            System.out.println(ClassLayout.parseInstance(testDemo).toPrintable());
        }

    }
}