package com.example.demo.sort;

import java.util.Arrays;

public class TestRadixSort {
	public static void main(String[] args) {
		int[] arr = new int[] {53, 274, 4, 43, 7, 3, 239, 141, 43, 2};
		RadixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void RadixSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		//最大值为Integer.MAX_VALUE,即2147483647,最小值为Integer.MIN_VALUE 
		//-2147483648
		//找到数组中的最大值
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		int maxlength = (max + "").length();
		//将最大的数变为字符串，求字符串长度，此时的长度为数位大小
		//https://baike.baidu.com/item/%E6%95%B0%E4%BD%8D/6157143?fr=aladdin
		int[][] temp = new int[10][arr.length];
		//第一次找到274，百位为2，2放在temp
		int[] count = new int[10] ;
		for(int i = 0, n = 1; i < maxlength; i++, n*=10) {
			for(int j = 0; j < arr.length; j++) {
				int ys = (arr[j]/n)%10;
				temp[ys][count[ys]] = arr[j];
				count[ys]++;
				//看图
			}
//			if(i == 0) {
//				for(int[] nums:temp) {
//					System.out.println(Arrays.toString(nums));
//				}
//				System.out.println(Arrays.toString(count));
//			}
			int index = 0;
			for(int k = 0; k < count.length; k++) {
			//遍历0，1，2，3，4..., 9
				if(count[k] != 0) {
					for(int o = 0; o < count[k]; o++) {
					//遍历count的数
						arr[index] = temp[k][o];
						index++;
					}
					//每一次遍历完将当前计数设置为0，以便下次计数为0时不会记录相同的数
					count[k] = 0;
				}
			}
		}
		
	}
}
