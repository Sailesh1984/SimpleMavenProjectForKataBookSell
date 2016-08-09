package kata.booksell.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kata.booksell.model.BillingForm;
import kata.booksell.model.Book;
import kata.booksell.model.BookForm;
import kata.booksell.service.BookService;

public class BookSellingController {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		boolean validInput= false;
		List<Book> bookList= new ArrayList<Book>();
		while(!validInput){
			try{
				System.out.println("Enter the The 1st Harry Books Quantity to Buy :");
				int i = sc.nextInt();
				Book book = new Book();
				book.setName("The 1st Harry Books");
				book.setQuantity(i);
				book.setPrice(8);
				book.setSerialId(1111);
				bookList.add(book);
				validInput = true;
			}catch(Exception e){
				System.out.println("Invalid input!!!!, Please enter valid integer value to buy. \n \n");
			}
		}
		validInput= false;
		while(!validInput){
			try{
				System.out.println("Enter the The 2nd Harry Books Quantity to Buy :");
				int i = sc.nextInt();
				Book book = new Book();
				book.setName("The 2nd Harry Books");
				book.setQuantity(i);
				book.setPrice(8);
				book.setSerialId(1112);
				bookList.add(book);
				validInput = true;
			}catch(Exception e){
				System.out.println("Invalid input!!!!, Please enter valid integer value to buy. \n \n");
			}
		}
		validInput= false;
		while(!validInput){
			try{
				System.out.println("Enter the The 3rd Harry Books Quantity to Buy :");
				int i = sc.nextInt();
				Book book = new Book();
				book.setName("The 3rd Harry Books");
				book.setQuantity(i);
				book.setPrice(8);
				book.setSerialId(1113);
				bookList.add(book);
				validInput = true;
			}catch(Exception e){
				System.out.println("Invalid input!!!!, Please enter valid integer value to buy. \n \n");
			}
		}
		validInput= false;
		while(!validInput){
			try{
				System.out.println("Enter the The 4th Harry Books Quantity to Buy :");
				int i = sc.nextInt();
				Book book = new Book();
				book.setName("The 4th Harry Books");
				book.setQuantity(i);
				book.setPrice(8);
				book.setSerialId(1114);
				bookList.add(book);
				validInput = true;
			}catch(Exception e){
				System.out.println("Invalid input!!!!, Please enter valid integer value to buy. \n \n");
			}
		}
		validInput= false;
		while(!validInput){
			try{
				System.out.println("Enter the The 5th Harry Books Quantity to Buy :");
				int i = sc.nextInt();
				Book book = new Book();
				book.setName("The 5th Harry Books");
				book.setQuantity(i);
				book.setPrice(8);
				book.setSerialId(1115);
				bookList.add(book);
				validInput = true;
			}catch(Exception e){
				System.out.println("Invalid input!!!!, Please enter valid integer value to buy. \n \n");
			}
		}
		
		BookService service = new BookService();
		BookForm bookForm = new BookForm();
		bookForm.setBooks(bookList);
		BillingForm billingForm = service.getBillingInfo(bookForm);
		System.out.println("billingForm List :"+ billingForm.getBooks().size());
		System.out.format("%10s%20s%10s%10s", "SERIAL ID", "BOOK NAME", "PRICE", "QANTITY" );
		System.out.println();
		for(Book book: billingForm.getBooks()){
			System.out.format("%10d%20s%10s%10s%n", book.getSerialId(), book.getName(), book.getQuantity(), String.format( "%.2f",book.getPrice()));
		}
		
		System.out.println();
		System.out.println();
		System.out.format("%25s%8s%n", "Total Gross Amount :",String.format( "%.2f",billingForm.getGrossTotalPrice()));
		System.out.format("%25s%8s%n", "Total Discount Amount :","-"+String.format( "%.2f",billingForm.getTotalDiscountPrice()));
		System.out.format("%25s%8s%n", "Total Gross Amount :",String.format( "%.2f",billingForm.getNetTotalPrice()));
		
	}
}
