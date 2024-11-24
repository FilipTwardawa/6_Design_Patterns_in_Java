package Service;

import Model.Book;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean borrowBook(User user, Book book) {
        if (!books.contains(book)) {
            System.out.println("Book not available: " + book.getTitle());
            return false;
        }

        if (user.getMaxBooks() <= 0) {
            System.out.println(user.getName() + " cannot borrow more books.");
            return false;
        }

        books.remove(book);
        System.out.println(user.getName() + " borrowed " + book.getTitle());
        return true;
    }

    public void displayAvailableBooks() {
        System.out.println("Available books:");
        books.forEach(System.out::println);
    }

    public void displayUsers() {
        System.out.println("Registered users:");
        users.forEach(System.out::println);
    }
}
