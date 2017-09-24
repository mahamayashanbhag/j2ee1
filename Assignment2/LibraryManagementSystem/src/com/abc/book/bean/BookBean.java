package com.abc.book.bean;

public class BookBean extends AuthorBean
{
	private String Isbn;
	private String bookName;
	private AuthorBean  Author;
	private char bookType;
	private float cost;
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public AuthorBean getAuthor() {
		return Author;
	}
	public void setAuthor(AuthorBean author) {
		Author = author;
	}
	public char getBookType() {
		return bookType;
	}
	public void setBookType(char bookType) {
		this.bookType = bookType;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
}	