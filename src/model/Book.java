package model;

public class Book {
	private int bookId;
	private String category;
	private String title;
	private String author;
	private String publisher;
	private String publishYear;
	private int edition;
	private String description;
	private double cost;
	private int qty;

	// Constructor with parameters
	public Book(int bookId, String category, String title, String author, String publisher, String publishYear,
			int edition, String description, double cost, int qty) {
		super();
		this.bookId = bookId;
		this.category = category;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.edition = edition;
		this.description = description;
		this.cost = cost;
		this.qty = qty;
	}

	// Default constructor
	public Book() {
		super();
	}

	// Getters and setters for each field
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
