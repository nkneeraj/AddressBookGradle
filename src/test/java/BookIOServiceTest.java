import com.cg.address.book.*;
import com.cg.addressbook.contact.Contact;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class BookIOServiceTest {
     
	@Test
	public void readTest() {
		BookIOService addressBookFileIOService = new BookIOService();
		List<Contact> contactList = new ArrayList<>();
		contactList = addressBookFileIOService.readData();
		System.out.println(contactList);
		Assert.assertEquals(2, contactList.size());
	}
	
	@Test
	public void writeTest() {
		BookIOService BookIOService = new BookIOService();
		List<Contact> contactList = new ArrayList<>();
		Contact contact1 = new Contact("Neeraj", "Kumar", "asd", "akg", "WB", "7878787878", "xyz@abc.com");
		Contact contact2 = new Contact("Neeraj1", "Kumar1", "asd", "akg", "WB", "7878787878", "xyz@abc.com");
		contactList.add(contact1);
		contactList.add(contact2);
		BookIOService.writeData(contactList);
		Assert.assertEquals(2, BookIOService.countEntries());
	}
}
