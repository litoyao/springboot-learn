package com.example.demo.threads;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private BlockingQueue queue;
    private boolean isRunning = true;
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("启动消费者线程！");
        Random random = new Random();
        isRunning = true;
        try {
            while (isRunning) {
                System.out.println("正在从队列里获取数据");
                String data = (String) queue.poll(2, TimeUnit.SECONDS);
                if (null != data) {
                    System.out.println("拿到数据 ：" + data);
                    System.out.println("正在消费数据：" + data);
                    Thread.sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                } else {
                    // 超过2s还没数据，认为所有生产线都已经退出，自动退出消费线程
                    isRunning = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("退出消费者线程!");
        }
    }
}