package com.liboru.datastructure.linkedlist.doubly;

public class Hero implements Comparable<Hero> {
	
	private int no;
	private String name;
	private String nickName;
	
	public Hero() {
		super();
	}
	public Hero(int no, String name,String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "Hero [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
	@Override
	public int compareTo(Hero hero) {
		return Integer.compare(this.no, hero.no);
	}

}
