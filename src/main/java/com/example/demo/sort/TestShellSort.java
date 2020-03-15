package com.example.demo.sort;

import java.util.Arrays;

/*
 * 希尔排序
 * @author Ravanla
 * 思路：
 * 1.设置一个增量s,记录每次arr的长度除以2的值
 * 	1.设置一个i等于这个s，i从这个数组的一半开始每次循环加一
 * 	 1.设置一个j等于i - s，每次减s个增量，减到小于0为止
 * 	  1.在这里进行下标i和下标j的值的对比
 * 当增量序列为dlta[k]=2t-k+1-1（0≤k≤t≤⌊log2(n+1)⌋）时，可以获得不错的效率
 */
public class TestShellSort {
	public static void main(String[] args) {
		int[] arr = new int[] {5, 7, 4, 3, 7, 3, 9, 1, 0};
		System.out.println(Arrays.toString(arr));
		ShellSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	public static void ShellSort(int[] arr) {
		for(int s = arr.length/2; s > 0; s/=2) {
		//s
			for(int i = s; i < arr.length; i++) {
//				for(int j = i - s; j < arr.length; j+=s)
				for(int j = i - s; j >= 0; j-=s){
				//第一次的i - s就等于0   表示arr[j]从数组下标零开始  
				//每隔s个位置经行比较
				//之后的i - s
					if(arr[i] < arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}

		}
	}
}
