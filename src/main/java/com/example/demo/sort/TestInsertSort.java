package com.example.demo.sort;

import java.util.Arrays;

public class TestInsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 4, 3, 7, 3, 9, 1, 0};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }

            System.out.println(Arrays.toString(arr));
        }

    }
}
