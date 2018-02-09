package com.soecode.chr.entity;

import java.util.Date;

/**
 * 预约图书实体
 * */
public class Appointment {

	//图书ID
	private long bookId;
	
	//学号
	private long studentId;
	
	//预约时间
	private Date appointTime;
	
	//多对一的复合属性
	//图书实体
	private Book book;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public Date getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Appointment(long bookId, long studentId, Date appointTime, Book book) {
		super();
		this.bookId = bookId;
		this.studentId = studentId;
		this.appointTime = appointTime;
		this.book = book;
	}

	@Override
	public String toString() {
		return "Appointment [bookId=" + bookId + ", studentId=" + studentId + ", appointTime=" + appointTime + ", book="
				+ book + "]";
	}
	
	
}
