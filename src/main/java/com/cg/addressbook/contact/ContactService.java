package com.cg.addressbook.contact;

import java.util.List;

public interface ContactService {
	
	public Contact addContact();
	public void updateContact(String firstName, List<Contact> contactList);
//	public void displayContact(String contact);

}
