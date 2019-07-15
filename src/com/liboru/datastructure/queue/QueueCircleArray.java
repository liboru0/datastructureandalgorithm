package com.liboru.datastructure.queue;

import java.util.Arrays;

public class QueueCircleArray<E> {
	
	private int maxSize;
	
	private int front = 0; // 队首，指向队首的前一个位置
	private int rear = 0; // 队尾，执行队尾的后一个元素
	
	private Object[] elementData;

	public QueueCircleArray() {
		this(101);
	}
	
	// 指定容量
	public QueueCircleArray(int maxSize) {
		this.maxSize = maxSize+1; // 由于有一个是空位，所以需要加一
		elementData = new Object[maxSize+1];
	}
	
	private boolean isFull(){
		return (rear+1)%maxSize == front;
	}
	
	private boolean isEmpty(){
		return front == rear;
	}
	
	// 入队
	public boolean add(E e){
		
		if(isFull()){
			throw new RuntimeException("队列已满");
		}
		
		// 因为rear指向的是最好一个元素的后一个位置，所以直接在此位置添加即可
		elementData[rear] = e;
		
		// 将rear后移
		rear = (rear+1)%maxSize;
		
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
		
		E e = elementData(front);
		
		// 后移
		front = (front+1)%maxSize;
		
		return e;
		
	}
	
	/**
	 * 队列中有效的数据的个数
	 */
	public int size(){
		return (rear+maxSize-front)%maxSize;
	}

	@Override
	public String toString() {
		
		Object[] temp = new Object[size()];
		
		for(int i=front,j=0;i<front+size();i++,j++){
			temp[j] = elementData[i%maxSize];
		}
		
		return Arrays.asList(temp).toString();
	}
	
	// 展示队首元素，并不出队
	public E headQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列为空");
		}
		
		return elementData(front);
	}
	
}
