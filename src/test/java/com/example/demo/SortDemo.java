package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class SortDemo {

    public static void mergeSort(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        int i, j;
        for (i = 0, j = 0; i < a.length && j < b.length; ) {
            if (a[i] < b[j]) {
                list.add(a[i++]);
            } else {
                list.add(b[j++]);
            }
        }

        if (i < a.length) {
            list.add(a[i++]);
        }

        if (i < b.length) {
            list.add(b[j++]);
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11};
        int[] b = {2, 4, 6, 8, 10};
        mergeSort(a, b);


    }
}
