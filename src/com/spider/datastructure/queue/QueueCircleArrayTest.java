package com.spider.datastructure.queue;

public class QueueCircleArrayTest {
	
	public static void main(String[] args) {
		
		QueueCircleArray<Integer> queue = new QueueCircleArray<>(4);
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		System.out.println(queue.toString());
		
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());
		queue.add(5);
		queue.add(6);
		queue.add(7);
		queue.add(8);
		
		System.out.println(queue.toString());
		
		
	}
	
	
}
