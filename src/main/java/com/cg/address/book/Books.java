package com.cg.address.book;

import java.util.*;

public class Books {
	private Scanner sc = new Scanner(System.in);

	Map<String, Book> books = new HashMap<>();

	public Books() {
		books = new HashMap<>();
	}

	public void searchByCityAndState(String city, String state) {

		books.entrySet().stream().forEach(e -> {
			e.getValue().getContactList().stream().forEach(x -> {
				if (x.getCity().equalsIgnoreCase(city) || x.getState().equalsIgnoreCase(state)) {
					System.out.println(x.getFirstName() + " " + x.getLastName());
				}
			});
		});
	}

	public void openBook() {
		System.out.println("Enter name of addressbook");
		String bookName = sc.nextLine();
		boolean bookPresent = books.containsKey(bookName);

		if (bookPresent) {
			Book book = books.get(bookName);
			System.out.println("Welcome to Book: " + bookName);
			System.out.println("Enter 1 to add contact");
			System.out.println("Enter 2 to edit contact");
			System.out.println("Enter 3 to delete existing contact");
			System.out.println("Enter 4 to exit");

			int input = sc.nextInt();
			sc.nextLine();
			while (input != 4) {
				if (input == 1) {
					book.addContact(book);
				} else if (input == 2) {
					System.out.println("Enter First Name :");
					String firstName = sc.nextLine();
					book.updateContact(firstName, book);
				} else if (input == 3) {
					System.out.println("Enter First Name of contact that need to be deleted.");
					String firstName = sc.nextLine();
					book.deleteContact(firstName);
				} else if (input == 4) {
					System.out.println("Exit");
					break;
				} else
					System.out.println("Wrong entry");
				System.out.println("Enter 1 to add contact");
				System.out.println("Enter 2 to edit contact");
				System.out.println("Enter 3 to delete an existing contact");
				System.out.println("Enter 4 to exit");
				input = sc.nextInt();
				sc.nextLine();
			}
		} else
			System.out.println("Book not found");
	}

	public void createBook() {

		Book book = new Book();
		System.out.println("Enter name of new book: ");
		String bookName = sc.nextLine();
		boolean bookPresent = books.containsKey(bookName);
		while (bookPresent) {
			System.out.println("Book already present");
			bookName = sc.nextLine();
			bookPresent = books.containsKey(bookName);
		}
		books.put(bookName, book);
	}

}
