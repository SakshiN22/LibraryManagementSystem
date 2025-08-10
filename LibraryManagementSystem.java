package Javaprograms;
import java.util.ArrayList;
import java.util.Scanner;

	class Book {
	    int id;
	    String title;
	    String author;
	    boolean isIssued;

	    Book(int id, String title, String author) {
	        this.id = id;
	        this.title = title;
	        this.author = author;
	        this.isIssued = false; 
	    }

	    void displayInfo() {
	        System.out.println(id + " - " + title + " by " + author + (isIssued ? " (Issued)" : " (Available)"));
	    }
	}

	class Library {
	    ArrayList<Book> books = new ArrayList<>();

	    void addBook(Book book) {
	        books.add(book);
	        System.out.println("Book added successfully!");
	    }

	    void viewBooks() {
	        if (books.isEmpty()) {
	            System.out.println("No books in the library yet!");
	        } else {
	            for (Book b : books) {
	                b.displayInfo();
	            }
	        }
	    }

	    void issueBook(int bookId) {
	        for (Book b : books) {
	            if (b.id == bookId) {
	                if (!b.isIssued) {
	                    b.isIssued = true;
	                    System.out.println("Book issued successfully!");
	                } else {
	                    System.out.println("Book is already issued!");
	                }
	                return;
	            }
	        }
	        System.out.println("Book not found!");
	    }

	    void returnBook(int bookId) {
	        for (Book b : books) {
	            if (b.id == bookId) {
	                if (b.isIssued) {
	                    b.isIssued = false;
	                    System.out.println("Book returned successfully!");
	                } else {
	                    System.out.println("This book was not issued!");
	                }
	                return;
	            }
	        }
	        System.out.println("Book not found!");
	    }
	}

	public class LibraryManagementSystem {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Library library = new Library();

	        while (true) {
	            System.out.println("\n=== Library Menu ===");
	            System.out.println("1. Add Book");
	            System.out.println("2. View Books");
	            System.out.println("3. Issue Book");
	            System.out.println("4. Return Book");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter book ID: ");
	                    int id = sc.nextInt();
	                    sc.nextLine(); // clear buffer
	                    System.out.print("Enter title: ");
	                    String title = sc.nextLine();
	                    System.out.print("Enter author: ");
	                    String author = sc.nextLine();
	                    library.addBook(new Book(id, title, author));
	                    break;

	                case 2:
	                    library.viewBooks();
	                    break;

	                case 3:
	                    System.out.print("Enter book ID to issue: ");
	                    int issueId = sc.nextInt();
	                    library.issueBook(issueId);
	                    break;

	                case 4:
	                    System.out.print("Enter book ID to return: ");
	                    int returnId = sc.nextInt();
	                    library.returnBook(returnId);
	                    break;

	                case 5:
	                    System.out.println("Exiting Library System... Goodbye!");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice! Please try again.");
	            }
	       }
	 }
}


