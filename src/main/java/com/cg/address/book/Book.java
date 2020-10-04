package com.cg.address.book;

import com.cg.addressbook.contact.*;
import java.util.*;

public class Book {

	private List<Contact> contactList = new ArrayList<>();
	ContactServiceImp contactService = new ContactServiceImp();
	Contact contact = new Contact();

	public void addContact() {
		contactList.add(contactService.addContact());
	}

	public void updateContact(String firstName) {
		contactService.updateContact(firstName, contactList);

	}

	public void deleteContact(String firstName) {
		boolean contactPresent = false;
		for (Contact contact : contactList) {
			if (contact.getFirstName().equalsIgnoreCase(firstName)) {
				contactPresent = true;
				break;
			}
		}
		if (contactPresent) {
			contactList.remove(contact);
			System.out.println("contact deleted successfully");
		} else
			System.out.println("No entry found");
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

}
