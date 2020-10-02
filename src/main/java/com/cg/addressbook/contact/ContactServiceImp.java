package com.cg.addressbook.contact;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cg.address.*;
import com.cg.addressbook.contact.*;
import com.cg.address.book.*;

import com.cg.address.book.Book;

public class ContactServiceImp implements ContactService {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the User Registration portal");
	}

	Contact contact = new Contact();
	Book book = new Book();

	public void addContact() {
		contact.setFirstName(firstName());
		contact.setLastName(lastName());
		contact.setEmail(email());
		contact.setCity(city());
		contact.setState(state());
		contact.setPhoneNumber(phoneNumber());
//		return contact;
		book.addContact(contact);
	}
	
	public void updateContact(String firstName) {
		for (Contact contact : book.getContactList()) {
			if (contact.getFirstName().equalsIgnoreCase(firstName)) {
				int i = 1;
				while (i != 0) {
					System.out.println("Enter 1 to update th last name");
					System.out.println("Enter 2 to update the address");
					System.out.println("Enter 3 to update the city");
					System.out.println("Enter 4 to update the state");
					System.out.println("Enter 5 to update the phone number");
					System.out.println("Enter 6 to update the email");
					System.out.println("Enter 0 to exit");
					i = sc.nextInt();
					sc.nextLine();
					switch (i) {
					case 1:
						System.out.println("Enter the new last name");
						contact.setLastName(sc.nextLine());
						System.out.println("last name updated");
						break;
					case 2:
						System.out.println("Enter the new address");
						contact.setAddress(sc.nextLine());
						System.out.println("address updated");
						break;
					case 3:
						System.out.println("Enter the new city");
						contact.setCity(sc.nextLine());
						System.out.println("city updated");
						break;
					case 4:
						System.out.println("Enter the new state");
						contact.setState(sc.nextLine());
						System.out.println("state updated");
						break;
					case 5:
						System.out.println("Enter the new phonenumber");
						contact.setPhoneNumber(sc.nextLine());
						System.out.println("phonenumber updated");
						break;
					case 6:
						System.out.println("Enter the new email");
						contact.setEmail(sc.nextLine());
						System.out.println("email updated");
						break;
					case 7:
						System.out.println("Exit");
						break;
					default:
						System.out.println("Invalid Entry! Enter a new one");

					}
				}

			} else
				System.out.println("no match found");

		}

		System.out.println("no match found");
	}

	public Contact getContact() {
		return contact;
	}

	public static String firstName() {
		System.out.println("Enter a user name with first capital character and min 3 length:");
		String firstName = sc.nextLine();
		Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]{2,}$");
		Matcher matcher = pattern.matcher(firstName);
		if (matcher.find())
			System.out.println("Valid Entry");
		else {
			System.out.println("Invalid entry, Re-enter valid entry:first capital character and min 3 length");
			firstName();
		}
		return firstName;
	}

	public static String lastName() {
		System.out.println("Enter last name with first capital character and min 3 length:");
		String lastName = sc.nextLine();
		Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]{2,}$");
		Matcher matcher = pattern.matcher(lastName);
		if (matcher.find())
			System.out.println("Valid Entry");
		else {
			System.out.println("Invalid entry, Re-enter valid entry:first capital character and min 3 length");
			lastName();
		}
		return lastName;
	}

	public static String email() {
		System.out.println("Enter valid email having Email");
		String email = sc.nextLine();
		Pattern pattern = Pattern.compile("^[a-z]+([-+-.]{0,1}[a-zA-z0-9]{1,})?@[a-z]{2,}\\.[a-z]{2,4}(\\.[a-z]{2})?$");
		Matcher matcher = pattern.matcher(email);
		if (matcher.find())
			System.out.println("Valid Entry");
		else {
			System.out.println("Invalid entry");
			email();
		}
		return email;
	}

	public static String city() {
		System.out.println("Enter city");
		String city = sc.nextLine();
		return city;
	}

	public static String state() {
		System.out.println("Enter state");
		String city = sc.nextLine();
		return city;
	}

	public static String phoneNumber() {
		System.out.println("Enter country code followed by space and 10 digit number");
		String phoneNumber = sc.nextLine();
		Pattern pattern = Pattern.compile("^[0-9]{2}\s[1-9]{1}[0-9]{9}$");
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.find())
			System.out.println("Valid Entry");
		else {
			System.out
					.println("Invalid entry, Re-enter valid entry:country code followed by space and 10 digit number");
			phoneNumber();
		}
		return phoneNumber;
	}
}
