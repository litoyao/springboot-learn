package com.example.demo.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 8, 4);

        Collections.sort(list, (Integer a, Integer b) -> {
            if (a > b)
                return -1;
            else
                return 1;
        });

        System.out.println(list);
    }

}
