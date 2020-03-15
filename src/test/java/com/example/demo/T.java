package com.example.demo;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class T {

    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        String str = input;
        if (str.startsWith("-")) {
            sb.append("-");
            str = str.substring(1);
        }

        boolean flag = true;

        String[] items = str.split("");
        for (int i = items.length - 1; i >= 0; i--) {
            if (flag && items[i].equals("0")) {
                continue;
            }
            flag = false;
            sb.append(items[i]);
        }

        return sb.toString();

    }


    public void sort() {
        List<String> arrays = Arrays.asList("aa", "cc", "bb");
        Collections.sort(arrays, (String a, String b) -> {
            return a.compareTo(b);
        });
    }

    public static void test1() {
        StringBuilder sb = new StringBuilder("buffering");
        sb.replace(2, 7, "BUFFER");
        System.out.println(sb.toString());
        sb.delete(2, 4);
        System.out.println(sb.toString());

        System.out.println(sb.subSequence(1, 5));
    }


    public static void test2() {
        int a = -1;
        System.out.println(a >>> 0);
        System.out.println(a >>> 1);
        System.out.println(a >>> 32);
        System.out.println(a >> 1);
        System.out.println(a >> 32);
    }

    public static void main(String[] args) {
       System.out.println(Stream.of("green","yellow","blue")
                .max((s1,s2)-> s1.compareTo(s2))
                .filter(s->s.endsWith("n"))
              .orElse("yellow")
       );
    }
}
