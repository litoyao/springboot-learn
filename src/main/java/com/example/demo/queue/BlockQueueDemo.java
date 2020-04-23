package com.example.demo.queue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Integer> blockQueue = new ArrayBlockingQueue(100);
        blockQueue.put(11);
        blockQueue.put(22);
        Integer item=blockQueue.take();
        System.out.println(item);
        blockQueue.take();
       // blockQueue.take();

        List<String> list= Arrays.asList("a","b");
        CopyOnWriteArrayList<String> cpist = new CopyOnWriteArrayList(list);
        cpist.set(0,"c");
        //Thread.sleep(1000);
        System.out.println(cpist.get(0));



    }
}
