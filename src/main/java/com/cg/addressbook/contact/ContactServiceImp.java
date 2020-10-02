package com.cg.addressbook.contact;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactServiceImp implements ContactService {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the User Registration portal");
	}
	
	public Contact addContact()
	{
		Contact contact = new Contact();
		contact.setFirstName(firstName());
		contact.setLastName(lastName());
		contact.setEmail(email());
		contact.setCity(city());
		contact.setState(state());
		contact.setPhoneNumber(phoneNumber());	
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
	
	public static String lastName()
	{
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
	
	public static String email()
	{
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
	public static String city()
	{
		System.out.println("Enter city");
		String city = sc.nextLine();
		return city;
	}
	
	public static String state()
	{
		System.out.println("Enter state");
		String city = sc.nextLine();
		return city;
	}
		
	public static String phoneNumber()
	{
		System.out.println("Enter country code followed by space and 10 digit number");
		String phoneNumber = sc.nextLine();
		Pattern pattern = Pattern.compile("^[0-9]{2}\s[1-9]{1}[0-9]{9}$");
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.find())
			System.out.println("Valid Entry");
		else {
			System.out.println("Invalid entry, Re-enter valid entry:country code followed by space and 10 digit number");
			phoneNumber();
		}
		return phoneNumber;
	}
}
