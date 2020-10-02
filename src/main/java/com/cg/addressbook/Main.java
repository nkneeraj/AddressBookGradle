package com.cg.addressbook;
import com.cg.addressbook.contact.*;
import com.cg.address.book.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book");
		
		System.out.println("Create Address Book");
		Book book = new Book();
		
		System.out.println("Add a new Contact");
		ContactServiceImp contact = new ContactServiceImp();
		book.addContact(contact.addContact());		
		System.out.println(contact);
	}
}
