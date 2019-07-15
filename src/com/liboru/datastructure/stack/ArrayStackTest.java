package com.liboru.datastructure.stack;

public class ArrayStackTest {
	
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack);
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}

	}
	
	
}
