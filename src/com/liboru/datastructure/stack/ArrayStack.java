package com.liboru.datastructure.stack;

import java.util.Arrays;

public class ArrayStack<E> {
	
	// 栈的容量
	private int maxSize;
	
	// 栈顶
	private int top = -1;
	
	private Object[] elementData;
	
	public ArrayStack(){
		this(100);
	}

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		elementData = new Object[maxSize];
	}
	
	
	public boolean isFull(){
		return top==maxSize-1;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	/**
	 * 入栈
	 */
	public void push(E e){
		if(isFull()){
			throw new RuntimeException("栈已满");
		}
		elementData[++top] = e;
	}
	
	/**
	 * 出栈
	 */
	public E pop(){
		if(isEmpty()){
			throw new RuntimeException("栈已空");
		}
		return elementData(top--);
	}
	
	/**
	 * 查看栈顶
	 */
	public E peek(){
		if(isEmpty()){
			throw new RuntimeException("栈已空");
		}
		return elementData(top);
	}
	
	@SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }
	
	@Override
	public String toString() {
		if(isEmpty()){
			return "";
		}
		return Arrays.asList(Arrays.copyOfRange(elementData, 0, top+1)).toString();
	}
	

}
