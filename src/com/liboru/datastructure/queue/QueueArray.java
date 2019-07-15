package com.liboru.datastructure.queue;

import java.util.Arrays;

public class QueueArray<E> {
	
	private int maxSize;
	
	private int front = -1; // 队首，指向队首的前一个位置
	private int rear = -1; // 队尾，执行队尾的数据
	
	private Object[] elementData;

	public QueueArray() {
		this(100);
	}
	
	public QueueArray(int maxSize) {
		this.maxSize = maxSize;
		elementData = new Object[maxSize];
	}
	
	private boolean isFull(){
		return rear == maxSize-1;
	}
	
	private boolean isEmpty(){
		return front == rear;
	}
	
	// 入队
	public boolean add(E e){
		
		if(isFull()){
			throw new RuntimeException("队列已满");
		}
		
		elementData[++rear] = e;
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }
	
	// 出队
	public E get(){
		
		if(isEmpty()){
			throw new RuntimeException("队列为空");
		}
		
		return elementData(++front);
		
	}

	@Override
	public String toString() {
		return Arrays.asList(Arrays.copyOfRange(elementData, front+1, rear+1)).toString();
	}
	
	// 展示队首元素，并不出队
	public E headQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列为空");
		}
		
		return elementData(front+1);
	}
	
}
