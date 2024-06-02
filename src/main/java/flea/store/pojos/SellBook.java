package flea.store.pojos;

import java.util.Arrays;

public class SellBook {
	//`_id`, `book_name`, `author_name`, `book_edition_year`, `category`, `price`, `book_language`, `description`, `book_photo`
    private int id;
    private String bookName;
    private String authorName;;
    private int bookEditionYear;
    private String category;
    private Double price;
    private String bookLanguage;
    private String description;
    private byte[] bookPhoto;
	public SellBook(int id, String bookName, String authorName, int bookEditionYear, String category, Double price,
			String bookLanguage, String description, byte[] bookPhoto) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookEditionYear = bookEditionYear;
		this.category = category;
		this.price = price;
		this.bookLanguage = bookLanguage;
		this.description = description;
		this.bookPhoto = bookPhoto;
	}
	public SellBook(String bookName, String authorName, int bookEditionYear, String category, Double price,
			String bookLanguage, String description, byte[] bookPhoto) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookEditionYear = bookEditionYear;
		this.category = category;
		this.price = price;
		this.bookLanguage = bookLanguage;
		this.description = description;
		this.bookPhoto = bookPhoto;
	}
	public int getId() {
		return id;
	}
	public SellBook() {
		super();
	}
	@Override
	public String toString() {
		return "SellBook [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", bookEditionYear="
				+ bookEditionYear + ", category=" + category + ", price=" + price + ", bookLanguage=" + bookLanguage
				+ ", description=" + description + ", bookPhoto=" + Arrays.toString(bookPhoto) + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getBookEditionYear() {
		return bookEditionYear;
	}
	public void setBookEditionYear(int bookEditionYear) {
		this.bookEditionYear = bookEditionYear;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBookLanguage() {
		return bookLanguage;
	}
	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getBookPhoto() {
		return bookPhoto;
	}
	public void setBookPhoto(byte[] bookPhoto) {
		this.bookPhoto = bookPhoto;
	}
    
}
