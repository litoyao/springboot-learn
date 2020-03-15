package com.example.demo.jdk8;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {


    public static void main(String[] args) {
        List<String> stringCollection = Arrays.asList("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1");

        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        System.out.println("----------------------");

        List<String> stringCollection2 = Arrays.asList("we are frends", "nice to meet you");
        stringCollection2
                .stream()
                .map(line -> line.split("\\s"))
                .flatMap(strs -> Arrays.stream(strs))
                .forEach(System.out::println);

    }

}
