package com.spider.datastructure.linkedlist.josepfu;

public class SingleCircleLinkedList<E> {
	
	public Node<E> first;
	
	private static class Node<E>{
		E item;
		Node<E> next;
		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}
	
	/**
	 * 加到链表尾部
	 */
	public void add(E e){
		Node<E> newNode = new Node<>(e,null);
		
		Node<E> cur = first;
		
		if(first==null){
			first = newNode;
		}else{
			while(cur.next!=first){
				cur = cur.next;
			}
			cur.next = newNode;
		}
		
		newNode.next = first;
		
	}

	@Override
	public String toString() {
		
		String str = "";
		
		Node<E> cur = first;
		
		if(first==null){
			return str;
		}
		
		str += cur.item.toString();
		
		while(cur.next!=first){
			cur = cur.next;
			str +="--->"+cur.item.toString();
		}
		
		return str;
		
	}
	
	/**
	 * @功能：约瑟夫问题
	 * @param startNo 表示从第几个节点开始数数
	 * @param countNum 表示数几下
	 * @param nums 表示最初的总节点数
	 */
	public void josepfu(int startNo,int countNum,int nums){
		
		// 数据校验
		if(first==null || startNo < 1 || startNo>nums){
			System.out.println("参数有误！！！");
			return;
		}
		
		// 创建辅助指针
		Node<E> helper = first;
		
		// 将helper指向链表的最后一个节点
		while(helper.next!=first){
			helper = helper.next;
		}
		
		System.out.println(helper.item);
		
		// 让helper和first移动k-1次
		for(int i=0;i<startNo-1;i++){
			first = first.next;
			helper = helper.next;
		}
		
		while(helper!=first){
			
			for(int i=0;i<countNum-1;i++){
				first = first.next;
				helper = helper.next;
			}
			
			System.out.println("出圈："+first.item.toString());
			
			first = first.next;
			helper.next = first;
			
		}
		
		System.out.println("出圈："+first.item.toString());
		
		first = null;
		
	}
	
	

}
