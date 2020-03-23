package com.example.demo.stream;

import java.util.stream.Stream;

public class Stream1 {

    public static void main(String[] args){
        Stream<String> stream = Stream.of("I", "love", "you", "too");

        Integer sum=stream.map(s->s.length())
                .reduce((a,b)->a+b)
                .get();
        System.out.println(sum);
    }

}
