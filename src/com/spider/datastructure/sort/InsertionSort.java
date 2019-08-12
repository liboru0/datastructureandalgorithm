package com.spider.datastructure.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			// 定义待插入的数及要插入的位置
			int insertVal = arr[i];
			int insertIndex = i - 1; // 即arr[i]前面那个数的下标

			/**
			 * 给insertVal找到插入的位置
			 * 	若insertVal小于arr[insertIndex],将arr[insertIndex]后移
			 */
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			
			// 当退出while循环时,说明插入位置找到,位置是insertIndex+1
			arr[insertIndex+1] = insertVal;

		}

	}

	public static void main(String[] args) {
		int length = 80000;
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = (int)(Math.random()*8000000); // 生成一个[0,8000000)的随机数
		}
		
		//InsertionSort.print(arr);
		long start = System.currentTimeMillis();
		InsertionSort.sort(arr);
		long end = System.currentTimeMillis();
		InsertionSort.print(arr);
		System.out.println("共耗时："+(end-start)/1000+"秒");
	}

}
