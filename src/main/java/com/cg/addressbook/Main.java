package com.cg.addressbook;

import com.cg.addressbook.contact.*;
import com.cg.address.book.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		System.out.println("Welcome to the Address Book");

		Scanner sc = new Scanner(System.in);
		Book book = new Book();
		Books books = new Books();
		ContactServiceImp contactService = new ContactServiceImp();
		Contact contact = new Contact();
		System.out.println("Welcome to AddressBooks1");
		System.out.println("Enter 1 to Open existing addressbook");
		System.out.println("Enter 2 to Create new AddressBook");
		System.out.println("Enter 3 to search by city");
		System.out.println("Enter 4 to search by state");
		System.out.println("Enter 5 to get count of person by city");
		System.out.println("Enter 6 to get count of person by state");
		System.out.println("Enter 7 to sort person's name by alphabet");
		System.out.println("Enter 8 to exit");

		for (;;) {
			int input = sc.nextInt();
			sc.nextLine();
			if (input == 2) {
				books.openBook();
			} else if (input == 1) {
				books.createBook();
			} else if (input == 3) {
				System.out.println("Enter city name: ");
				String city = sc.nextLine();
				System.out.println(books.searchPersonsByCity(city));
			} else if (input == 4) {
				System.out.println("Enter State Name: ");
				String state = sc.nextLine();
				System.out.println(books.searchPersonsByState(state));
			}  else if (input == 5) {
				System.out.println("Enter city name: ");
				String city = sc.nextLine();
				System.out.println(books.countPersonsByCity(city));
			} else if (input == 6) {
				System.out.println("Enter State Name: ");
				String state = sc.nextLine();
				System.out.println(books.countPersonsByState(state));
			}else if(input==7){
				System.out.println(books.showContact());
			}else if (input == 8) {
				System.out.println("Exit");
				break;
			}
			else {
				System.out.println("Wrong entry");
			}
			System.out.println("Enter 1 to open existing AddressBook");
			System.out.println("Enter 2 to create new AddressBook");
			System.out.println("Enter 3 search by city.");
			System.out.println("Enter 4 to search by state");
			System.out.println("Enter 5 to get count of person by city");
			System.out.println("Enter 6 to get count of person by state");
			System.out.println("Enter 7 to sort person's name by alphabet");
			System.out.println("Enter 8 to exit");
		}
	}
}
