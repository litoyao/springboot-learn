package com.example.demo.threads;

public class WaitDemo {

    public static void main(String[] args) {

        Object lock = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("开始下载图片");
                for (int i = 0; i < 101; i += 10) {
                    System.out.println("down " + i + "%");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                synchronized (lock) {
                    lock.notifyAll();   //唤醒另一个线程
                }

                System.out.println("开始下载附件");
                for (int i = 0; i < 101; i += 10) {
                    System.out.println("附件下载" + i + "%");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Thread t2 = new Thread() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");

                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("show:开始展示图片");
                System.out.println("图片展示完毕");
            }

        };

        t1.start();
        t2.start();

    }
}