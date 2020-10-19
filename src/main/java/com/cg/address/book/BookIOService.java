package com.cg.address.book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.cg.addressbook.contact.Contact;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class BookIOService {

	public static String READ_FILE = "./readFile.txt";
	public static String WRITE_FILE = "writeFile.txt";
	
	public static final String SAMPLE_JSON_FILE_PATH = "./file1.json";
	public static final String SAMPLE_JSON_FILE_PATH2 = "./file.json";

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
	
	public boolean writeJsonData(List<Contact> contactList) {
		Gson gson = new Gson();
		String json = gson.toJson(contactList);
		try {
			FileWriter fileWriter = new FileWriter(SAMPLE_JSON_FILE_PATH);
			fileWriter.write(json);
			fileWriter.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean readJsonFile(){
		try {
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_JSON_FILE_PATH2));
			JsonParser jsonParser = new JsonParser();
			JsonElement obj = jsonParser.parse(reader);
			JsonArray contactList = (JsonArray) obj;
			System.out.println(contactList);
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}