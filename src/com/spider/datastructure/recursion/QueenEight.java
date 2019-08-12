package com.spider.datastructure.recursion;

public class QueenEight {

	private int max = 8;

	private int[] array = new int[max];

	private int count = 0;

	public int getCount() {
		return count;
	}

	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

	/**
	 * 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
	 * 
	 * @param n
	 *            表示第几个皇后
	 * @return
	 */
	private boolean judge(int n) {

		for (int i = 0; i < n; i++) {
			/**
			 * 1. array[i] == array[n] 表示判断是否在同一列 2. Math.abs(n-i) ==
			 * Math.abs(array[n]-array[i]) 表示判断是否在同一斜线 3. 不用判断是否在同一行，因为n每次都在递增
			 */
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}

		return true;

	}

	/**
	 * 放置第n个皇后
	 * 
	 * @param n
	 */
	public void check(int n) {

		if (n == max) {
			this.print();
			return;
		}

		// 依次放入皇后，并判断是否冲突
		for (int i = 0; i < max; i++) {
			// 放置到第i列
			array[n] = i;
			// 检查是否冲突
			if (this.judge(n)) {
				// 接着放第n+1个皇后
				this.check(n + 1);
			}
			// 如果冲突，就继续下一个循环 放置到下一列
		}

	}

	public static void main(String[] args) {
		QueenEight q8 = new QueenEight();
		q8.check(0);
		System.out.println(q8.getCount());
	}

}
