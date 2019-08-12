package com.spider.datastructure.sort;

import java.util.Arrays;

public class ShellSortSwap {

	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		ShellSortSwap.print(arr);
		ShellSortSwap.sort(arr);
	}

	public static void sort(int[] arr) {
		int temp = 0;
		for (int i = 5; i < arr.length; i++) {
			// 遍历各组中所有的元素
			for (int j = i - 5; j >= 0; j -= 5) {
				// 如果当前元素大于加上步长后的那个元素，说明需要交换
				if (arr[j] > arr[j + 5]) {
					temp = arr[j];
					arr[j] = arr[j + 5];
					arr[j + 5] = temp;
				}
			}
		}
		ShellSortSwap.print(arr);
		for (int i = 2; i < arr.length; i++) {
			// 遍历各组中所有的元素
			for (int j = i - 2; j >= 0; j -= 2) {
				// 如果当前元素大于加上步长后的那个元素，说明需要交换
				if (arr[j] > arr[j + 2]) {
					temp = arr[j];
					arr[j] = arr[j + 2];
					arr[j + 2] = temp;
				}
			}
		}
		ShellSortSwap.print(arr);
	}

}
