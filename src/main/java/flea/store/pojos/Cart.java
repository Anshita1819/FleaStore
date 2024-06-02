package flea.store.pojos;

public class Cart {
	
	private int id;
	private String name;
	private double price;
	private String category;
	private double quantity;
	public Cart() {
		super();
		
	}
	public Cart(int id, String name, double price, String category,int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.quantity=quantity;
	}
	public Cart(String name, double price, String category,int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.quantity=quantity;
	}
	public int getId() {
		return id;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
