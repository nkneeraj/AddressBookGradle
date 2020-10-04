package com.cg.address.book;

import com.cg.addressbook.contact.*;
import java.util.*;

public class Book {
	
	private List<Contact> contactList = new ArrayList<>();
//	ContactServiceImp contactService = new ContactServiceImp();
	Contact contact = new Contact();
	
	public void addContact(Contact contact) {
		contactList.add(contact);
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

}
