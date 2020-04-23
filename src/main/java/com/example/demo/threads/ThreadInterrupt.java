package com.example.demo.threads;

public class ThreadInterrupt {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            int i = 0;
            while (true) {
                i++;

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("i=" + i);
                    break;
                }
            }
        });

        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();

        System.out.println("t1 is dead? " + t1.isInterrupted());
        System.out.println("t1 is dead? " + t1.isInterrupted());


    }
}
