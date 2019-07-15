package com.liboru.datastructure.queue;

public class QueueArrayTest {
	
	public static void main(String[] args) {
		
		QueueArray<Integer> queue = new QueueArray<>(4);
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.headQueue());
		
		System.out.println(queue.toString());
		
		
	}
	
	
}
