package com.spider.datastructure.recursion;

public class MiGong {

	public static void main(String[] args) {
		// 先创建一个二维数组模拟迷宫
		// 地图
		int[][] map = new int[8][7];
		// 使用1表示墙
		// 上下置为1
		for (int i = 0; i < map[0].length; i++) {
			map[0][i] = 1;
			map[map.length - 1][i] = 1;
		}
		// 左右置为1
		for (int i = 0; i < map.length; i++) {
			map[i][0] = 1;
			map[i][map[0].length - 1] = 1;
		}

		// 设置障碍
		map[3][1] = 1;
		map[3][2] = 1;
		map[2][2] = 1;

		MiGong.printMap(map);
		
		// 使用递归回溯给小球找路
		MiGong.setWay(map, 1, 1);
		System.out.println("----------------------------");
		MiGong.printMap(map);
		

	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 使用递归回溯来给小球找路，右下脚为出口 约定：当map[i][j]为0表示该点还没走过，当为1时表示墙， 当为2时表示走过的通路(2即为路径)
	 * 当为3是表示走过的路但是走不通 策略：在走迷宫时需要确定一个策略 下->右->上->左,如果都走不通再回溯
	 * 
	 * @param map
	 *            迷宫
	 * @param i
	 *            位置横标
	 * @param j
	 *            位置纵标
	 * @return true为此路通，false为此路不通
	 */
	public static boolean setWay(int[][] map, int i, int j) {

		// 通路已经找到
		if (map[map.length - 2][map[0].length - 2] == 2) {
			return true;
		} else {
			if(map[i][j]==0){ // 如果当前位置还没有走过
				map[i][j] = 2;
				if(setWay(map,i+1,j)){ // 向下走
					return true;
				}else if(setWay(map,i,j+1)){ // 向右走
					return true;
				}else if(setWay(map,i-1,j)){ // 向上走
					return true;
				}else if(setWay(map,i,j-1)){ // 向左走
					return true;
				}else{
					//若都没走通，则说明此路不通，置成3
					map[i][j] = 3;
					return false;
				}
			}else{
				// 非0，及为1、2、3 三种情况都返回false
				return false;
			}
		}

	}

}
