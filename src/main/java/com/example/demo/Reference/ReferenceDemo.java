package com.example.demo.Reference;

import com.example.demo.aop.Person;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceDemo {

    public static void main(String[] args) {
        SoftReference<Person> p = new SoftReference<>(new Person());
        p.get().sayHi();

        WeakReference<Person> wp = new WeakReference<>(new Person());
        wp.get().sayBye();

        System.gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (wp.get() == null) {
            System.out.println("weak reference is dead.");
        } else {
            System.out.println("weak reference is still alive.");
        }
    }
}
