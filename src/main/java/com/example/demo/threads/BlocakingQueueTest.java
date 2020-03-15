package com.example.demo.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlocakingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue(10);
        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);
        Consumer c = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        //启动线程
        service.execute(p1);
        service.execute(p2);
        service.execute(p3);
        service.execute(c);
        //运行10s
        Thread.sleep(10 * 1000);
        p1.stop();
        p2.stop();
        p3.stop();

        Thread.sleep(2000);

        //退出executor
        service.shutdown();


    }
}