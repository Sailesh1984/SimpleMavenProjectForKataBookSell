package kata.booksell.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kata.booksell.model.BillingForm;
import kata.booksell.model.Book;
import kata.booksell.model.BookForm;
import kata.booksell.service.BookService;

public class KataBookServiceTest {	
	BookService service = new BookService();
	@BeforeClass
	public static void setup(){}
	
	@AfterClass
	public static void teardown(){
		   
	}
	public Map<Integer, Book> getHashMapFordeductMinQuantityFromEachElementOfMapTest(){
		Map<Integer, Book> map = new HashMap<Integer, Book>();
		Book book1 = new Book();
		book1.setSerialId(5);
		book1.setPrice(10);
		book1.setName("The First Harry Advanture");
		book1.setQuantity(2);
		map.put(5,book1);

		Book book2 = new Book();
		book2.setSerialId(1);
		book2.setPrice(10);
		book2.setName("The Second Harry Advanture");
		book2.setQuantity(2);
		map.put(1,book2);

		Book book3 = new Book();
		book3.setSerialId(2);
		book3.setPrice(10);
		book3.setName("The Third Harry Advanture");
		book3.setQuantity(2);
		map.put(2, book3);

		Book book4 = new Book();
		book4.setSerialId(3);
		book4.setPrice(10);
		book4.setName("The Fourth Harry Advanture");
		book4.setQuantity(1);
		map.put(3,book4);

		Book book5 = new Book();
		book5.setSerialId(4);
		book5.setPrice(10);
		book5.setName("The Fiveth Harry Advanture");
		book5.setQuantity(1);
		map.put(4,book5);
		return map;
	}
	
	private BookForm getBookForm(){
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setSerialId(1111);
		book1.setPrice(8);
		book1.setName("The First Harry Advanture");
		bookList.add(book1);

		Book book2 = new Book();
		book2.setSerialId(1112);
		book2.setPrice(8);
		book2.setName("The Second Harry Advanture");
		bookList.add(book2);

		Book book3 = new Book();
		book3.setSerialId(1113);
		book3.setPrice(8);
		book3.setName("The Third Harry Advanture");
		bookList.add(book3);

		Book book4 = new Book();
		book4.setSerialId(1114);
		book4.setPrice(8);
		book4.setName("The Fourth Harry Advanture");
		bookList.add(book4);

		Book book5 = new Book();
		book5.setSerialId(1115);
		book5.setPrice(8);
		book5.setName("The Fiveth Harry Advanture");
		bookList.add(book5);
		
		BookForm form = new BookForm();
		form.setBooks(bookList);
		return form;
	}
	
	private BookForm getBooksForcalculateGrossTotalPriceTest(){
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setSerialId(1111);
		book1.setPrice(8);
		book1.setName("The First Harry Advanture");
		book1.setQuantity(2);
		bookList.add(book1);

		Book book2 = new Book();
		book2.setSerialId(1112);
		book2.setPrice(8);
		book2.setName("The Second Harry Advanture");
		book2.setQuantity(0);
		bookList.add(book2);

		Book book3 = new Book();
		book3.setSerialId(1113);
		book3.setPrice(8);
		book3.setName("The Third Harry Advanture");
		book3.setQuantity(2);
		bookList.add(book3);

		Book book4 = new Book();
		book4.setSerialId(1114);
		book4.setPrice(8);
		book4.setName("The Fourth Harry Advanture");
		book4.setQuantity(0);
		bookList.add(book4);

		Book book5 = new Book();
		book5.setSerialId(1115);
		book5.setPrice(8);
		book5.setName("The Fiveth Harry Advanture");
		book5.setQuantity(01);
		bookList.add(book5);
		
		BookForm form = new BookForm();
		form.setBooks(bookList);
		return form;
	}
	
	@Test
	public void calculateNetTotalPricetest(){
		double result = service.calculateNetTotalPrice(6, 2);
		assertEquals(result, 4, 0);
	}
	
	@Test
	public void getooksInfoTest(){
		List<Book> books = service.getooksInfo();
		assertEquals(books.get(0).getSerialId(),1111);
	}
	@Test
	public void getDiscuontPercentageTestForTwo(){
		double percentage =  service.getDiscuontPercentage(2);
		assertEquals(percentage, 5, 0);
	}
	@Test
	public void getDiscuontPercentageTestForThree(){
		double percentage =  service.getDiscuontPercentage(3);
		assertEquals(percentage, 10, 0);
	}
	@Test
	public void getDiscuontPercentageTestForFour(){
		double percentage =  service.getDiscuontPercentage(4);
		assertEquals(percentage, 20, 0);
	}
	@Test
	public void getDiscuontPercentageTestForFive(){
		double percentage =  service.getDiscuontPercentage(5);
		assertEquals(percentage, 25, 0);
	}
	@Test
	public void getDiscuontPercentageTestForOne(){
		double percentage =  service.getDiscuontPercentage(1);
		assertEquals(percentage, 0, 0);
	}
	
	@Test
	public void getBookPriceTest(){
		double price = service.getBookPrice(1111);
		assertEquals(price, 8, 0);
	}
	
	@Test
	public void deductMinQuantityFromEachElementOfMapTest(){
		Map<Integer, Book> map = service.deductMinQuantityFromEachElementOfMap(getHashMapFordeductMinQuantityFromEachElementOfMapTest(), 1);
		assertEquals(map.size(), 3);		
	}
	@Test 
	public void minimumQantityInMapTest(){
		int minValue = service.minimumQantityInMap(getHashMapFordeductMinQuantityFromEachElementOfMapTest());
		assertEquals(minValue, 1);
	}
	@Test
	public void convertListToMapTest(){
		Map<Integer,Book> map = service.convertListToMap(getBookForm().getBooks());
		assertEquals(map.size(), 5);
	}
	@Test 
	public void calculateDiscountPriceTest(){
		double discountAmount = service.calculateDiscountPrice(getHashMapFordeductMinQuantityFromEachElementOfMapTest());
		assertEquals(discountAmount, 12.4,1);
	}
	
	@Test
	public void calculateGrossTotalPriceTest(){
		double grossValue = service.calculateGrossTotalPrice(getBooksForcalculateGrossTotalPriceTest().getBooks());
		assertEquals(grossValue, 40, 0);
	}
	@Test
	public void filterValidRecordTest(){
		List<Book> books = service.filterValidRecord(getBooksForcalculateGrossTotalPriceTest());
		assertEquals(books.size(),3);
	}
	
	@Test
	public void getBillingInfoTest(){
		BillingForm form = service.getBillingInfo(getBooksForcalculateGrossTotalPriceTest());
		assertEquals(form.getNetTotalPrice(), 36.8,1);
	}
	
	private BookForm getBooksForcalculateNetTotalPriceTest(){
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setSerialId(1111);
		book1.setPrice(8);
		book1.setName("The First Harry Advanture");
		book1.setQuantity(2);
		bookList.add(book1);

		Book book2 = new Book();
		book2.setSerialId(1112);
		book2.setPrice(8);
		book2.setName("The Second Harry Advanture");
		book2.setQuantity(2);
		bookList.add(book2);

		Book book3 = new Book();
		book3.setSerialId(1113);
		book3.setPrice(8);
		book3.setName("The Third Harry Advanture");
		book3.setQuantity(2);
		bookList.add(book3);

		Book book4 = new Book();
		book4.setSerialId(1114);
		book4.setPrice(8);
		book4.setName("The Fourth Harry Advanture");
		book4.setQuantity(2);
		bookList.add(book4);

		Book book5 = new Book();
		book5.setSerialId(1115);
		book5.setPrice(8);
		book5.setName("The Fiveth Harry Advanture");
		book5.setQuantity(0);
		bookList.add(book5);
		
		BookForm form = new BookForm();
		form.setBooks(bookList);
		return form;
	}
	@Test
	public void getBillingInfoTestForTwoSetOfFOurDifferentBook(){
		BillingForm form = service.getBillingInfo(getBooksForcalculateNetTotalPriceTest());
		assertEquals(form.getNetTotalPrice(), 51.2,2);
	}
	
	private BookForm getBooksForcalculateNetTotalPriceTestForoneSetOfFiveBookAndOneSetofThreeBook(){
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setSerialId(1111);
		book1.setPrice(8);
		book1.setName("The First Harry Advanture");
		book1.setQuantity(2);
		bookList.add(book1);

		Book book2 = new Book();
		book2.setSerialId(1112);
		book2.setPrice(8);
		book2.setName("The Second Harry Advanture");
		book2.setQuantity(2);
		bookList.add(book2);

		Book book3 = new Book();
		book3.setSerialId(1113);
		book3.setPrice(8);
		book3.setName("The Third Harry Advanture");
		book3.setQuantity(2);
		bookList.add(book3);

		Book book4 = new Book();
		book4.setSerialId(1114);
		book4.setPrice(8);
		book4.setName("The Fourth Harry Advanture");
		book4.setQuantity(1);
		bookList.add(book4);

		Book book5 = new Book();
		book5.setSerialId(1115);
		book5.setPrice(8);
		book5.setName("The Fiveth Harry Advanture");
		book5.setQuantity(1);
		bookList.add(book5);
		
		BookForm form = new BookForm();
		form.setBooks(bookList);
		return form;
	}
	@Test
	public void getBillingInfoTestForOneSetOf5DifferentBookAndOneSetOfThreeDifferentBook(){
		BillingForm form = service.getBillingInfo(getBooksForcalculateNetTotalPriceTestForoneSetOfFiveBookAndOneSetofThreeBook());
		assertEquals(form.getNetTotalPrice(), 51.6,2);
	}
}
