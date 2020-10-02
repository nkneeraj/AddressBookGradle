package com.cg.address.book;

import com.cg.addressbook.contact.*;
import java.util.*;

public class Book {

	public void addContact(Contact Contact) {
		contactList.add(Contact);
	}

	private List<Contact> contactList = new ArrayList<>();

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

}
