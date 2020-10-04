package com.cg.addressbook;

import com.cg.addressbook.contact.*;
import com.cg.address.book.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		System.out.println("Welcome to the Address Book");

		Scanner sc = new Scanner(System.in);
		Book book = new Book();
		ContactServiceImp contactService = new ContactServiceImp();
		Contact contact = new Contact();
		System.out.println("Welcome to Book");
		System.out.println("Enter 1 to add contact");
		System.out.println("Enter 2 to edit contact");
		System.out.println("Enter 3 to exit");

		int input = sc.nextInt();
		sc.nextLine();
		while (input != 3) {
			if (input == 1) {
				contactService.addContact();
				System.out.println("Enter 1 to add contact");
				System.out.println("Enter 2 to edit contact");
				System.out.println("Enter 3 to exit");
				input = sc.nextInt();sc.nextLine();
				} else if (input == 2) {
				System.out.println("Enter First Name :");
				String firstName = sc.nextLine();
				contactService.updateContact(firstName);
				System.out.println("Enter 1 to add contact");
		        System.out.println("Enter 2 to edit contact");
		        System.out.println("Enter 3 to exit");
		        input = sc.nextInt();sc.nextLine();
		        } else
				System.out.println("Exit");
		}

//		System.out.println("Add a new Contact");
//		ContactServiceImp contact = new ContactServiceImp();
//	book.addContact(contact.addContact());		
//		contact.addContact();
//		System.out.println(contact.getContact());
//		Contact contact1 = new Contact();
//		System.out.println(contact1.get);
//		System.out.println("update contact");
//		System.out.println("Enter first name:");
//		String firstName = sc.nextLine();
//		contact.updateContact(firstName);
	}
}
