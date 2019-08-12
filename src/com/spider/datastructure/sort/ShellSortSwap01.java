package com.spider.datastructure.sort;

import java.util.Arrays;

public class ShellSortSwap01 {

	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		ShellSortSwap01.print(arr);
		ShellSortSwap01.sort(arr);
	}

	public static void sort(int[] a) {
		
		int n=a.length;
        int gap=n/2;
        while(gap>=1){
            for(int i=gap;i<a.length;i++){
                int j=0;
                int temp = a[i];
                for(j=i-gap;j>=0 && temp<a[j];j=j-gap){
                    a[j+gap] = a[j];
                }
                a[j+gap] = temp;
            }
            ShellSortSwap01.print(a);
            gap = gap/2;
        }
		
		
		
	}

}
