package com.liboru.datastructure.linkedlist.doubly;

public class DoubleLinkedList<E extends Comparable<E>> {
	
	private Node<E> head = new Node<E>(null,null,null);
	
	private static class Node<E extends Comparable<E>> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
	
	/**
	 * 加到链表最后
	 */
	public void add(E e){
		
		Node<E> nodeNew = new Node<E>(null,e, null);
		
		Node<E> temp = head;
		
		while(temp.next!=null){
			temp = temp.next;
		}
		
		temp.next = nodeNew;
		nodeNew.prev = temp;
		
	}
	
	public void addOrder(E e){
		
		Node<E> nodeNew = new Node<E>(null,e, null);
		
		Node<E> temp = head;
		
		boolean flag = false;
		
		while(temp.next!=null){
			temp = temp.next;
			if(temp.item.compareTo(e)>0){
				flag = true;
				break;
			}
		}
		
		if(flag){
			temp.prev.next = nodeNew;
			nodeNew.prev = temp.prev;
			nodeNew.next = temp;
			temp.prev = nodeNew;
		}else{
			temp.next = nodeNew;
			nodeNew.prev = temp;
		}
		
	}
	
	@Override
	public String toString(){
		String str = "head";
		
		Node<E> temp = head;
		
		while(temp.next!=null){
			temp = temp.next;
			str += "--->"+temp.item.toString();
		}
		
		return str;
	}
	
	public void delete(E e){
		
		Node<E> temp = head;
		
		while(temp.next!=null){
			
			temp = temp.next;
			
			if(temp.item.equals(e)){
				temp.prev.next = temp.next;
				if(temp.next!=null){
					temp.next.prev = temp.prev;
				}
				break;
			}
			
		}
		
	}

}
