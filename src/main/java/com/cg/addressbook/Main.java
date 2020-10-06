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
		System.out.println("Enter 3 to search by city and state");
		System.out.println("Enter 4 to exit");
//
//		int input = sc.nextInt();
//		sc.nextLine();
		
		
		for(;;) {
			int input = sc.nextInt();
			sc.nextLine();
			if (input == 2) {
				books.openBook();
			} else if (input == 1) {
				books.createBook();	
			} else if (input == 3) {
				System.out.println("Enter city name: ");
				String city = sc.nextLine();
				System.out.println("Enter state name: ");
				String state = sc.nextLine();
				books.searchByCityAndState(city, state);
			} else if (input == 4) {
				System.out.println("Exit");
				break;
			}
				System.out.println("Wrong entry");
				System.out.println("Enter 1 to Create AddressBook");
				System.out.println("Enter 2 to open existing AddressBook");
				System.out.println("Enter 3 search by city and state");
				System.out.println("Enter 4 to exit");		
		}
	}
}
