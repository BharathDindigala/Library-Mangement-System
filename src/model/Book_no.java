package model;

public class Book_no {
	private int bookNo;
	private int bookId;
	private String status;
	private String remarks;

	// Constructor with parameters
	public Book_no(int bookNo, int bookId, String status, String remarks) {
		this.bookNo = bookNo;
		this.bookId = bookId;
		this.status = status;
		this.remarks = remarks;
	}

	// Default constructor
	public Book_no() {
	}

	// Getters and setters
	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
