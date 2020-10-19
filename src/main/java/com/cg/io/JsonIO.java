package com.cg.io;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cg.address.book.Book;
import com.cg.addressbook.contact.Contact;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class JsonIO {
	public static List<Contact> readCSV(Path p) {
		List<Contact> CsvLIST = new ArrayList<>();
		try {
			Reader reader = Files.newBufferedReader(p);
			CsvToBean<Contact> csvToBean = new CsvToBeanBuilder<Contact>(reader)
					.withType(Contact.class).withIgnoreLeadingWhiteSpace(true).build();
			Iterator<Contact> iterator = csvToBean.iterator();
			while (iterator.hasNext()) {
				CsvLIST.add(iterator.next());
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return CsvLIST;
	}

	public static void writeCSV(Path p, Book addressBook) {
		try {
			Writer writer = Files
					.newBufferedWriter(Paths.get("G:\\Training\\Gradle1\\AddressBookProject\\com.cg.adp\\AB4.csv"));
			StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder<Contact>(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
			beanToCsv.write(addressBook.getAddressBook());
			writer.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (CsvDataTypeMismatchException e) {
			System.out.println(e.getMessage());
		} catch (CsvRequiredFieldEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}
