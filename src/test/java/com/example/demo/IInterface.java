package com.example.demo;

public interface IInterface {
      String a ="kk";

      default void print(){
        System.out.println("in the IInterface.");
      }

    void run();
}
