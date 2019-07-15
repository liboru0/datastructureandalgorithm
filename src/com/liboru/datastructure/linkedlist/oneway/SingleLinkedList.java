package com.liboru.datastructure.linkedlist.oneway;

import java.util.Stack;

/**
 * 由于支持排序，所以元素类型需要实现Comparable接口
 * @author lbr
 */
public class SingleLinkedList<E extends Comparable<E>> {
	
	private Node<E> head = new Node<E>(null,null);
	
	@SuppressWarnings("hiding")
	private class Node<E extends Comparable<E>> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
	
	/**
	 * 加到链表最后
	 */
	public void add(E e){
		
		Node<E> nodeNew = new Node<E>(e, null);
		
		//由于没有维护指向链表最后节点的lastNode，所以需要遍历找到
		Node<E> temp = head;
		
		while(temp.next!=null){
			temp = temp.next;
		}
		
		temp.next = nodeNew;
		
	}
	
	/**
	 * 有序添加，E需要实现Comparable接口，默认升序
	 * 相同顺序抛出异常
	 */
	public void addByOrder(E e){
		
		Node<E> nodeNew = new Node<E>(e, null);
		
		Node<E> temp = head;
		Node<E> pre = null; // temp前边的一个节点
		
		boolean flag = false; // 是否找到位置
		
		while(temp.next!=null){
			pre = temp;
			temp = temp.next;
			if(temp.item.compareTo(nodeNew.item)==0){
				throw new RuntimeException("顺序重复");
			}
			if(temp.item.compareTo(nodeNew.item)>0){
				flag = true;
				break;
			}
		}
		
		// 如果找到位置就放到它前边，否则放到后边(即链表最后)
		if(flag){
			pre.next = nodeNew;
			nodeNew.next = temp;
		}else{
			temp.next = nodeNew;
		}
		
		
	}
	
	public void delete(E e){
		Node<E> nodeNew = new Node<E>(e, null);
		
		Node<E> temp = head;
		Node<E> pre = null; // temp前边的一个节点
		
		boolean flag = false; // 是否找到该节点
		
		while(temp.next!=null){
			pre = temp;
			temp = temp.next;
			if(temp.item.equals(nodeNew.item)){
				flag = true;
				break;
			}
		}
		
		if(flag){
			pre.next = temp.next;
		}
		
	}
	
	public String toString(){
		String str = "head";
		
		Node<E> temp = head;
		
		while(temp.next!=null){
			temp = temp.next;
			str += "--->"+temp.item.toString();
		}
		
		return str;
	}
	
	public int getLength(){
		int len = 0;
		
		Node<E> temp = head;
		
		while(temp.next!=null){
			len++;
			temp = temp.next;
		}
		
		return len;
	}
	
	/**
	 * 查找单链表的倒数第n个元素
	 */
	public E lastIndexOf(int lastIndex){
		
		int index = this.getLength()-lastIndex+1;
		
		Node<E> temp = head;
		
		int i = 0;
		
		while(temp.next!=null){
			if(++i==index){
				return temp.next.item;
			}
			temp = temp.next;
		}
		
		return null;
	}
	
	/**
	 * 反转单链表
	 * 从头遍历，没找到一个元素都把他放到最前端
	 */
	public void reverse(){
		
		//如果没有节点或只有一个节点，不需反转
		if(head.next==null||head.next.next==null){
			return;
		}
		
		Node<E> cur = head.next;
		Node<E> next = null;
		
		Node<E> reverseHead = new Node<E>(null,null);
		
		while(cur!=null){
			next = cur.next; // 暂存当前节点的下个节点，因为后边要重新制定cur.next
			cur.next = reverseHead.next; // 将cur.next指向新链表的最前端
			reverseHead.next = cur; // 将cur连接到新链表上
			cur = next; 
		}
		
		head.next = reverseHead.next;
		
	}
	
	/**
	 * 倒序遍历单链表
	 */
	public void reversePrint(){
		Node<E> temp = head.next;
		if(temp==null){
			return;
		}
		Stack<E> stack = new Stack<>();
		while(temp!=null){
			stack.push(temp.item);
			temp = temp.next;
		}
		while(stack.size()>0){
			System.out.println(stack.pop());
		}
	}

}
