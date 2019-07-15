package com.liboru.datastructure.linkedlist.oneway;

public class SingleLinkedListTest {
	
	public static void main(String[] args) {
		SingleLinkedList<Hero> linkedList = new SingleLinkedList<>();
		Hero hero1 = new Hero(1,"宋江","及時雨");
		Hero hero2 = new Hero(2,"卢俊义","玉麒麟");
		Hero hero3 = new Hero(3,"吴用","智多星");
		Hero hero4 = new Hero(4,"林冲","豹子头");
		linkedList.addByOrder(hero1);
		linkedList.addByOrder(hero4);
		linkedList.addByOrder(hero2);
		linkedList.addByOrder(hero3);
		System.out.println(linkedList);
		
		linkedList.reversePrint();
		
	}
	
	
}
