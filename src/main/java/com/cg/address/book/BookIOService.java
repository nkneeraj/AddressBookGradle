package com.cg.address.book;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.cg.addressbook.contact.Contact;

public class BookIOService {

	public static String READ_FILE = "./readFile.txt";
	public static String WRITE_FILE = "writeFile.txt";

	public void writeData(List<Contact> contactList) {
		StringBuffer empBuffer = new StringBuffer();
		contactList.forEach(contact -> {
			String employeeDataString = contact.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(WRITE_FILE), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Contact> readData() {
		List<Contact> contactsList = new ArrayList<>();
		try {
			Files.lines(Paths.get(READ_FILE)).map(line -> line.trim()).forEach(line -> {
				String[] words = line.split("[\\s,:]+");

				Contact contact = new Contact();
				contact.setFirstName(words[1]);
				contact.setLastName(words[3]);
				contact.setAddress(words[5]);
				contact.setCity(words[7]);
				contact.setState(words[9]);
				contact.setPhoneNumber(words[13]);
				contact.setEmail(words[15]);
				contactsList.add(contact);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contactsList;
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(WRITE_FILE).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
}