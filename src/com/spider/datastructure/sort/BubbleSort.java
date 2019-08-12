package com.spider.datastructure.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void sort(int[] arr) {
		int temp = 0;

		boolean flag = false; // 一趟比较(一次外层循环)是否发生过至少一次交换

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			// 如果没有发生交换，说明已经有序，跳出循环
			if (!flag) {
				break;
			} else {
				flag = false; // 重置flag
			}

		}

	}

	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {

		int length = 80000;
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = (int)(Math.random()*8000000); // 生成一个[0,8000000)的随机数
		}
		
		//BubbleSort.print(arr);
		long start = System.currentTimeMillis();
		BubbleSort.sort(arr);
		long end = System.currentTimeMillis();
		BubbleSort.print(arr);
		System.out.println("共耗时："+(end-start)/1000+"秒");

	}

}
