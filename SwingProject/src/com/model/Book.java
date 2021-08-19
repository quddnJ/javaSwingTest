package com.model;

public class Book {
	private int num;
	private String title;
	private String writer;
	private String indate;
	private String outdate;
	private String gubun;
	private int price;
	
	public Book() {} //이거 없으면 Book b = new Book 이게 안됨
	public Book(String title, String writer, String indate, String outdate, String gubun, int price) {
	//	super();
		this.title = title;
		this.writer = writer;
		this.indate = indate;
		this.outdate = outdate;
		this.gubun = gubun;
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
