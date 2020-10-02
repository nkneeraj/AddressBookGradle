package com.cg.addressbook;
import com.cg.addressbook.contact.*;
import com.cg.address.book.*;
import java.util.*;


public class Main {

	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Address Book");
		
		System.out.println("Create Address Book");
		Book book = new Book();
		
		System.out.println("Add a new Contact");
		ContactServiceImp contact = new ContactServiceImp();
//		book.addContact(contact.addContact());		
		contact.addContact();
		System.out.println(contact.getContact());
//		Contact contact1 = new Contact();
//		System.out.println(contact1.get);
		System.out.println("update contact");
		System.out.println("Enter first name:");
		String firstName = sc.nextLine();
		contact.updateContact(firstName);
	}
}
