import Factory.UserFactory;
import Model.User;
import Observer.UserObserver;
import Singleton.DoubleCheckedLocking.LibraryCatalog;
import Book.Book;

public class Main {
    public static void main(String[] args) {

        // Singleton LibraryCatalog
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        // Creation of users and observers
        User student = UserFactory.createUser("student", "Alice");
        User teacher = UserFactory.createUser("teacher", "Bob");

        catalog.addObserver(new UserObserver(student));
        catalog.addObserver(new UserObserver(teacher));

        // Operations
        Book book1 = new Book("Java Programming", "John Doe", 2021);
        Book book2 = new Book("Design Patterns", "Eric Gamma", 1994);

        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.borrowBook("Java Programming");
        catalog.returnBook(book1);
    }

    }
