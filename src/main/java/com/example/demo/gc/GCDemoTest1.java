package com.example.demo.gc;

import java.util.ArrayList;
import java.util.List;

public class GCDemoTest1 {

    static class OOMObject {
        public byte[] placeHolder = new byte[64 * 1024];//64kb
    }

    public static void fileHeap(int num) throws InterruptedException {
        List<OOMObject> objects = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            objects.add(new OOMObject());
            System.out.println(i);
            Thread.sleep(100);
        }

        System.gc();

        while(true){

        }
    }

    public static void main(String[] args) throws InterruptedException {
        fileHeap(1000);
    }
}


