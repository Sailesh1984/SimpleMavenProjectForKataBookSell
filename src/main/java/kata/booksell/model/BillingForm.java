package kata.booksell.model;

import java.util.List;

public class BillingForm {
	List<Book> books;
	
	private double netTotalPrice;
	
	private double grossTotalPrice;
	
	private double totalDiscountPrice;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public double getNetTotalPrice() {
		return netTotalPrice;
	}

	public void setNetTotalPrice(double netTotalPrice) {
		this.netTotalPrice = netTotalPrice;
	}

	public double getGrossTotalPrice() {
		return grossTotalPrice;
	}

	public void setGrossTotalPrice(double grossTotalPrice) {
		this.grossTotalPrice = grossTotalPrice;
	}

	public double getTotalDiscountPrice() {
		return totalDiscountPrice;
	}

	public void setTotalDiscountPrice(double totalDiscountPrice) {
		this.totalDiscountPrice = totalDiscountPrice;
	}
	

}
