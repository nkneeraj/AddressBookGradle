package com.cg.addressbook;
import com.cg.addressbook.contact.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book");
		
		System.out.println("Add a new Contact");
		ContactServiceImp contact = new ContactServiceImp();
		contact.addContact();		
	}
}
