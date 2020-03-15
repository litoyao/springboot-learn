package com.example.demo.locks;

public class DemoExample1 {
    static TestDemo testDemo;
    public static void main(String[] args) throws Exception {
        testDemo= new TestDemo();
        synchronized (testDemo){
            System.out.println("lock ing");
            testDemo.hashCode();
        }
    }
}