package com.cg.address.book;

import com.cg.addressbook.contact.*;
import java.util.*;

public class Book {

	private List<Contact> contactList = new ArrayList<>();
	ContactServiceImp contactService = new ContactServiceImp();
	private Contact contact = new Contact();

	public void addContact(Book book) {
//		contactList.add(contactService.addContact());

		contact = contactService.addContact(book);
		String firstName = contact.getFirstName();
		System.out.println("bookaddcontact");
		boolean present = false;
//		for(Contact x: contactList)
//		{
//			if(x.getFirstName().equalsIgnoreCase(firstName)) {
//				System.out.println("Contact with same name present \n enter contact with different first name");
//				present = true;
//				break;
//			}			
//		}		
		present = book.getContactList().stream().anyMatch(n -> n.getFirstName().equalsIgnoreCase(firstName));
		if (present) {
			System.out.println("Contact with same name already present");
		} else
			contactList.add(contact);
	}

	public void updateContact(String firstName, Book book) {
//		List<Contact> contactList = book.getContactList(); 
		contactService.updateContact(firstName, book);

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
