package com.cg.addressbook.contact;

import java.util.List;

import com.cg.address.book.Book;

public interface ContactService {
	
	public Contact addContact(Book book);
	public void updateContact(String firstName, Book book);
//	public void displayContact(String contact);

}
