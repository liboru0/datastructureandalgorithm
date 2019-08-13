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
		
		int n=arr.length;
        int gap=n/2;
        while(gap>=1){
            for(int i=gap;i<arr.length;i++){
                int j=0;
                int temp = arr[i];
                for(j=i-gap;j>=0 && temp<arr[j];j=j-gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = temp;
            }
            ShellSortSwap.print(arr);
            gap = gap/2;
        }
		
		
		
	}

}
