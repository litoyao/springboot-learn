package com.example.demo.aop;

public class Person {
    public void sayHi() {
        try {
            Thread.currentThread().sleep(30);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi!!");
    }

    public void sayBye() {
        try {
            Thread.currentThread().sleep(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye!!");
    }
} 