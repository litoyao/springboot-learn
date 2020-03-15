package com.example.demo;

import java.util.function.Function;

public class FunctionTest {

    public static void test(){
        Function<Integer,Integer> test1= i->i+1;
        Function<Integer,Integer> test2=i->i*i;
        System.out.println(calculate(test1,5));
        System.out.println(calculate(test2,5));
    }
    public static Integer calculate(Function<Integer,Integer> test,Integer number){
        return test.apply(number);
    }

    public static void main(String[] args){
        FunctionTest.test();
    }
}
