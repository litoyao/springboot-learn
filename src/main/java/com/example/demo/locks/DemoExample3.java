package com.example.demo.locks;

public class DemoExample3 {
    public int sharedState;
 
    public void nonSafeAction() {
        while (sharedState < 100000) {
            int former = sharedState++;
            int latter = sharedState;
            if (former != latter - 1) {
                System.out.println("Observed data race, former is " +
                        former + ", " + "latter is " + latter);
            }
        }
    }
  
    public static void main(String[] args) throws InterruptedException {
        final DemoExample3 demoExample3 = new DemoExample3();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                demoExample3.nonSafeAction();
            }
        };
   
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                demoExample3.nonSafeAction();
            }
        };
 
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}