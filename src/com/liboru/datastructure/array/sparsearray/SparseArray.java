package com.liboru.datastructure.array.sparsearray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SparseArray {
	
	public static void main(String[] args) {
		
		SparseArray.arrayToSparse();
		System.out.println("===================================================");
		SparseArray.sparseToArray();
		
	}
	
	public static void arrayToSparse(){
		int[][] arrays = new int[11][10];
		arrays[1][2] = 1;
		arrays[10][3] = 3;
		
		// 遍历原始的二维数组，得到有效数据的个数sum
		int num = 0;
		for(int[] row : arrays){
			for(int col : row){
				if(col != 0){
					num++;
				}
			}
		}
		
		// 创建稀疏数组，并写入第一行数据
		int[][] sparseArray = new int[num+1][3];
		sparseArray[0][0] = arrays.length;
		sparseArray[0][1] = arrays[0].length;
		sparseArray[0][2] = num;
		
		// 将二维数组的有效数据存入到稀疏数组中
		int rowNum = 0;
		for(int i=0;i<arrays.length;i++){
			for(int j=0;j<arrays[i].length;j++){
				if(arrays[i][j] !=0 ){
					sparseArray[++rowNum][0] = i;
					sparseArray[rowNum][1] = j;
					sparseArray[rowNum][2] = arrays[i][j];
				}
			}
		}
		
		
		for(int[] row : sparseArray){
			for(int col : row){
				System.out.print(col+"\t");
			}
			System.out.println();
		}
		
		// 将稀疏数组保存到磁盘中
		File file = new File("D:\\sparseArray.data");
		ObjectOutput os = null;
		try {
			os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(sparseArray);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void sparseToArray(){
		
		// 从磁盘中读取稀疏数组
		File file = new File("D:\\sparseArray.data");
		ObjectInput oi = null;
		int[][] sparseArray = null;
		try{
			oi = new ObjectInputStream(new FileInputStream(file));
			sparseArray = (int[][])oi.readObject();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				oi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 根据稀疏数组第一行的数据创建原始二维数组
		int[][] arrays = new int[sparseArray[0][0]][sparseArray[0][1]];	
		
		// 再读取稀疏数组的后几行数据，赋值到二维数组中
		for(int i = 1 ; i<sparseArray.length ; i++){
			arrays[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		
		for(int[] row : arrays){
			for(int col : row){
				System.out.print(col+"\t");
			}
			System.out.println();
		}
		
	}

}
