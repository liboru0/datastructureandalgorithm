package com.liboru.datastructure.linkedlist.josepfu;

public class JosepfuTest {
	
	public static void main(String[] args) {
		
		SingleCircleLinkedList<Boy> josepfu = new SingleCircleLinkedList<>();
		
		for(int i=1;i<=25;i++){
			josepfu.add(new Boy(i));
		}
		
		josepfu.josepfu(1, 2, 25);
		
	}

}
