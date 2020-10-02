package com.cg.address.book;

import com.cg.address.*;
import com.cg.addressbook.contact.*;
import java.util.*;
public class Book {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private List<Contact> contactList;

	public void AddressBook(String name) {
		this.name = name;
		contactList= new ArrayList<Contact>();
	}

	public void addContact(Contact Contact) {
		contactList.add(Contact);
	}
}
