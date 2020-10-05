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
		System.out.println("Welcome to AddressBooks");
		System.out.println("Enter 1 to Open existing addressbook");
		System.out.println("Enter 2 to Create new AddressBook");
//		System.out.println("Enter 3 to delete existing contact");
		System.out.println("Enter 3 to exit");
//
		int input = sc.nextInt();
		sc.nextLine();
		while (input != 3) {
			if (input == 1) {
				books.openBook();
			} else if (input == 2) {	
				books.createBook();
//			} else if(input==3) {
//				System.out.println("Enter First Name of contact that need to be deleted.");
//				String firstName = sc.nextLine();
//				book.deleteContact(firstName);
			}	else if (input ==3) {
				System.out.println("Exit");
				break;
			}
			else
			System.out.println("Wrong entry");
			System.out.println("Enter 1 to open existing AddressBook");
			System.out.println("Enter 2 to create new AddressBook");
//			System.out.println("Enter 3 to delete an existing contact");
			System.out.println("Enter 3 to exit");
			input = sc.nextInt();
			sc.nextLine();
		}
	}
}
