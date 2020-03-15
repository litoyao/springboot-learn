package com.example.demo.threads;

public class SynchronizedDemo {

    static class Bank {
        private  long account = 0;


        public synchronized void deposit(long money) {

            this.account += money;

            System.out.println(Thread.currentThread().getName() + ":" + account);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class BandThread implements Runnable {

        private Bank bank;

        BandThread(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for(int i=0; i<10; i++) {
              this.bank.deposit(100);
            }
        }
    }

    public static void main(String[] args) {

        Bank bank1 = new SynchronizedDemo.Bank();
      //  Bank bank2 = new SynchronizedDemo.Bank();
        BandThread bandThread1 = new BandThread(bank1);
        BandThread bandThread2 = new BandThread(bank1);

        Thread t1 = new Thread(bandThread1, "thread1");
        Thread t2 = new Thread(bandThread2, "thread2");

        t1.start();
        t2.start();
    }
}
