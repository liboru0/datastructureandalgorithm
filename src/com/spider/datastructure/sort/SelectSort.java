package com.spider.datastructure.sort;

import java.util.Arrays;

public class SelectSort {

	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			
			int minIndex = i;
			int min = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					// 重置最小值
					min = arr[j];
					minIndex = j;
				}
			}

			// 当最小值下标发生了变化，再进行交换
			if(minIndex!=i){
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
			
		}

	}

	public static void main(String[] args) {
		int length = 80000;
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = (int)(Math.random()*8000000); // 生成一个[0,8000000)的随机数
		}
		
		//SelectSort.print(arr);
		long start = System.currentTimeMillis();
		SelectSort.sort(arr);
		long end = System.currentTimeMillis();
		SelectSort.print(arr);
		System.out.println("共耗时："+(end-start)/1000+"秒");
	}

}
