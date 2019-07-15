package com.spider.datastructure.linkedlist.doubly;


public class DoubleLinkedListTest {
	
	public static void main(String[] args) {
		DoubleLinkedList<Hero> linkedList = new DoubleLinkedList<>();
		Hero hero1 = new Hero(1,"宋江","及時雨");
		Hero hero2 = new Hero(2,"卢俊义","玉麒麟");
		Hero hero3 = new Hero(3,"吴用","智多星");
		Hero hero4 = new Hero(4,"林冲","豹子头");
		linkedList.addOrder(hero4);
		linkedList.addOrder(hero3);
		linkedList.addOrder(hero1);
		linkedList.addOrder(hero2);
		System.out.println(linkedList.toString());
	}

}
