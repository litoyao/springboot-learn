package com.example.demo;

import org.junit.jupiter.api.Test;

public class ClassForNameTest {

    @Test
    public void testClassForname(){
        try {
            Class.forName("com.example.demo.ClassForName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClassForname2(){
        System.out.println("---------------------");
        try {
            ClassLoader.getSystemClassLoader().loadClass("com.example.demo.ClassForName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
