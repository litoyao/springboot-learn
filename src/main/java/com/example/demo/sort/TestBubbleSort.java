package com.example.demo.sort;

import java.util.Arrays;

public class TestBubbleSort {
    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 7, 4, 3, 7, 3, 9, 1, 0};
        bubbleSort2(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            print(arr);
        }
    }


    public static void bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1-i ; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            print(arr);
        }
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));

    }
}

