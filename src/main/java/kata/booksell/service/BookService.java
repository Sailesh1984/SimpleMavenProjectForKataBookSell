package kata.booksell.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kata.booksell.model.BillingForm;
import kata.booksell.model.Book;
import kata.booksell.model.BookForm;

public class BookService {

	public List<Book> getooksInfo() {
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setSerialId(1111);
		book1.setPrice(getBookPrice(1111));
		book1.setName("The First Harry Advanture");
		bookList.add(book1);

		Book book2 = new Book();
		book2.setSerialId(1112);
		book2.setPrice(getBookPrice(1112));
		book2.setName("The Second Harry Advanture");
		bookList.add(book2);

		Book book3 = new Book();
		book3.setSerialId(1113);
		book3.setPrice(getBookPrice(1113));
		book3.setName("The Third Harry Advanture");
		bookList.add(book3);

		Book book4 = new Book();
		book4.setSerialId(1114);
		book4.setPrice(getBookPrice(1114));
		book4.setName("The Fourth Harry Advanture");
		bookList.add(book4);

		Book book5 = new Book();
		book5.setSerialId(1115);
		book5.setPrice(getBookPrice(1115));
		book5.setName("The Fiveth Harry Advanture");
		bookList.add(book5);
		return bookList;
	}

	public double getBookPrice(int serialId) {

		double price = 0;
		switch (serialId) {
		case 1111:
			price = 8;
			break;
		case 1112:
			price = 8;
			break;
		case 1113:
			price = 8;
			break;
		case 1114:
			price = 8;
			break;
		case 1115:
			price = 8;
			break;
		}
		return price;
	}
	
	public BillingForm getBillingInfo(BookForm bookForm){
		BillingForm billingForm= new BillingForm();
		//get the valid record whose quantity is more then 0
		List<Book> books = filterValidRecord(bookForm);
		billingForm.setBooks(books);
		
		//get gross price for order
		double grossTotalPrice = calculateGrossTotalPrice(books);
		billingForm.setGrossTotalPrice(grossTotalPrice);
		
		//get total discount price on the order
		double totalDiscountPrice = calculateDiscountPrice(convertListToMap(books));
		billingForm.setTotalDiscountPrice(totalDiscountPrice);
		
		//calculate the net total pay
		double netTotalPrice = calculateNetTotalPrice(grossTotalPrice, totalDiscountPrice);
		billingForm.setNetTotalPrice(netTotalPrice);
		return billingForm;
	}
	
	public List<Book> filterValidRecord(BookForm bookForm){
		List<Book> books = new ArrayList<Book>();
		for(Book book: bookForm.getBooks()){
			if(book.getQuantity()>0){
				books.add(book);
			}
		}
		return books;
	}

	public double calculateGrossTotalPrice(List<Book> books) {

		double grossTotalPrice = 0;
		for(Book book: books){
			grossTotalPrice = grossTotalPrice+ book.getQuantity()* book.getPrice();
		}
		return grossTotalPrice;
	}

	public double calculateDiscountPrice(Map<Integer, Book> books) {
		double totalDiscountPrice = 0;
		while(books.size()>1){
			int differentBookTypeQty = books.size();
			double discuontPercentage = getDiscuontPercentage(differentBookTypeQty);
			int getCountOfdifferentBooksSet = minimumQantityInMap(books);
			totalDiscountPrice = totalDiscountPrice+ (8*differentBookTypeQty*discuontPercentage/100)*getCountOfdifferentBooksSet;
			books = deductMinQuantityFromEachElementOfMap(books, getCountOfdifferentBooksSet);
		}	
		System.out.println("totalDiscountPrice" + totalDiscountPrice);
		return totalDiscountPrice;
	}

	public double calculateNetTotalPrice(double grossAmount,
			double dscountAmount) {
		return grossAmount - dscountAmount;
	}
	
	public Map<Integer, Book> convertListToMap(List<Book> books){
		Map<Integer, Book> bookMap = new HashMap<Integer, Book>();
		for(Book book: books){
			bookMap.put(book.getSerialId(), book);
		}
		return bookMap;
	}
	
	public int minimumQantityInMap(Map<Integer, Book> bookMap){
		int minQuantity = 0;
		for(int i: bookMap.keySet()){
			Book book = bookMap.get(i);
			if(minQuantity == 0){
				minQuantity = book.getQuantity();
			}else if(minQuantity> book.getQuantity()){
				minQuantity = book.getQuantity();
			}
		}
		return minQuantity;
	}
	
	public Map<Integer, Book> deductMinQuantityFromEachElementOfMap(Map<Integer, Book> bookMap, int minQuantity){
		Map<Integer, Book> map = new HashMap<Integer, Book>();
		for(int i: bookMap.keySet()){
			Book book = bookMap.get(i);
			if(minQuantity < book.getQuantity()){
				Book tempBook = new Book(book.getSerialId(), book.getName(), book.getPrice(), book.getQuantity()-minQuantity);
				map.put(tempBook.getSerialId(), tempBook);
			}
		}
		return map;
	}
	
	public double getDiscuontPercentage(int differentBookCount){
		double percentage = 0;
		switch(differentBookCount){
		case 2:
			percentage =5;
			break;
		case 3:
			percentage = 10;
			break;
		case 4:
			percentage =20;
			break;
		case 5:
			percentage = 25;
			break;
		default: 
			percentage = 0;
			break;
		}
		return percentage;
	}

}
