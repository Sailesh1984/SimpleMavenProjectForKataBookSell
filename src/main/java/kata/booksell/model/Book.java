package kata.booksell.model;

public class Book {
	public int serialId;
	public String name;
	public double price;
	public int quantity;
	
	public Book(){}
	
	public Book(int serialId, String name, double price, int quantity){
		this.serialId= serialId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public int getSerialId() {
		return serialId;
	}
	public void setSerialId(int serialId) {
		this.serialId = serialId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
