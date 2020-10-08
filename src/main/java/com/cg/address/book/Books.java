package com.cg.address.book;

import java.util.*;
import java.util.stream.Collectors;

import com.cg.addressbook.contact.Contact;

public class Books {
	private Scanner sc = new Scanner(System.in);
	Book book = new Book();
	Map<String, Book> books = new HashMap<>();
	Map<String, ArrayList<String>> City = new HashMap<>();
	Map<String, ArrayList<String>> State = new HashMap<>();

	Map<String, Integer> cityCount = new HashMap<>();
	Map<String, Integer> stateCount = new HashMap<>();

	public Books() {
		books = new HashMap<>();
	}

//	public void searchByCityAndState(String city, String state) {
//
//		books.entrySet().stream().forEach(e -> {
//			e.getValue().getContactList().stream().forEach(x -> {
//				if (x.getCity().equalsIgnoreCase(city) || x.getState().equalsIgnoreCase(state)) {
//					System.out.println(x.getFirstName() + " " + x.getLastName());
//				}
//			});
//		});
//	}
	
	public List<Contact> searchPersonsByCity(String city) {
		return book.getContactList().stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList());
	}
	
	public List<Contact> searchPersonsByState(String state) {
		return book.getContactList().stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList());
	}
	
	public int countPersonsByCity(String city) {
		return book.getContactList().stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList()).size();
	}

	public int countPersonsByState(String state) {
		return book.getContactList().stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList()).size();
	}
	
	public List<Contact> showContact(){
		return book.getContactList().stream().sorted((n1, n2) -> n1.getFirstName().compareTo(n2.getFirstName())).collect(Collectors.toList());
	}
	
	public List<Contact> sortCity(){
		return book.getContactList().stream().sorted((n1,n2) -> n1.getCity().compareTo(n2.getCity())).collect(Collectors.toList());
	}
	
	public List<Contact> sortState(){
		return book.getContactList().stream().sorted((n1,n2) -> n1.getState().compareTo(n2.getState())).collect(Collectors.toList());
	}
	
//	public void countByCity(String city, String state) {
//		books.entrySet().stream().forEach(e -> {
//			e.getValue().getContactList().stream().forEach(x -> {
//				if (cityCount.containsKey(x.getCity())) {
//					Integer cityCount1 = cityCount.get(x.getCity());
//					cityCount1++;
//					cityCount.replace(x.getCity(), cityCount1);
//				} else if (!cityCount.containsKey(x.getCity())) {
//					cityCount.put(x.getCity(), 1);
//				}
//				else if (stateCount.containsKey(x.getCity())) {
//					Integer stateCount1 = stateCount.get(x.getCity());
//					stateCount1++;
//					stateCount.replace(x.getCity(), stateCount1);
//				} else if (!stateCount.containsKey(x.getCity())) {
//					stateCount.put(x.getCity(), 1);
//				}
//			});
//		});
//
//		cityCount.entrySet().stream().forEach(n -> System.out.println(n));
//		stateCount.entrySet().stream().forEach(n -> System.out.println(n));
//	}

//	public void viewByCityOrState(String city, String state) {
//		books.entrySet().stream().forEach(e -> {
//			e.getValue().getContactList().stream().forEach(x -> {
//				if (City.containsKey(x.getCity())) {
//					ArrayList<String> list = City.get(x.getCity());
//					list.add(x.getFirstName() + " " + x.getLastName());
//					City.replace(x.getCity(), list);
//				} else if (!City.containsKey(x.getCity())) {
//					ArrayList<String> list = new ArrayList<>();
//					list.add(x.getFirstName() + " " + x.getLastName());
//					City.put(x.getCity(), list);
//				} else if (State.containsKey(x.getState())) {
//					ArrayList<String> list = City.get(x.getState());
//					list.add(x.getFirstName() + " " + x.getLastName());
//					City.replace(x.getState(), list);
//				} else if (!State.containsKey(x.getState())) {
//					ArrayList<String> list = new ArrayList<>();
//					list.add(x.getFirstName() + " " + x.getLastName());
//					City.put(x.getState(), list);
//				}
//			});
//		});
//
//		City.entrySet().stream().forEach(x -> {
//			x.getValue().stream().forEach(n -> System.out.println(n));
//		});
//
//		State.entrySet().stream().forEach(x -> {
//			x.getValue().stream().forEach(n -> System.out.println(n));
//		});
//
//	}

	public void openBook() {
		System.out.println("Enter name of addressbook");
		String bookName = sc.nextLine();
		boolean bookPresent = books.containsKey(bookName);

		if (bookPresent) {
			Book book = books.get(bookName);
			System.out.println("Welcome to Book: " + bookName);
			System.out.println("Enter 1 to add contact");
			System.out.println("Enter 2 to edit contact");
			System.out.println("Enter 3 to delete existing contact");
			System.out.println("Enter 4 to exit");

			int input = sc.nextInt();
			sc.nextLine();
			while (input != 4) {
				if (input == 1) {
					book.addContact(book);
				} else if (input == 2) {
					System.out.println("Enter First Name :");
					String firstName = sc.nextLine();
					book.updateContact(firstName, book);
				} else if (input == 3) {
					System.out.println("Enter First Name of contact that need to be deleted.");
					String firstName = sc.nextLine();
					book.deleteContact(firstName);
				} else if (input == 4) {
					System.out.println("Exit");
					break;
				} else
					System.out.println("Wrong entry");
				System.out.println("Enter 1 to add contact");
				System.out.println("Enter 2 to edit contact");
				System.out.println("Enter 3 to delete an existing contact");
				System.out.println("Enter 4 to exit");
				input = sc.nextInt();
				sc.nextLine();
			}
		} else
			System.out.println("Book not found");
	}

	public void createBook() {

		Book book = new Book();
		System.out.println("Enter name of new book: ");
		String bookName = sc.nextLine();
		boolean bookPresent = books.containsKey(bookName);
		while (bookPresent) {
			System.out.println("Book already present");
			bookName = sc.nextLine();
			bookPresent = books.containsKey(bookName);
		}
		books.put(bookName, book);
	}

}
