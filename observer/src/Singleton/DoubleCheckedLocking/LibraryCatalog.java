package Singleton.DoubleCheckedLocking;

import Adapter.BookDataImporter;
import Adapter.CSVBookImporter;
import Adapter.JSONBookImporter;
import Adapter.XMLBookImporter;
import Book.Book;
import Observer.LibraryObserver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LibraryCatalog {
    private static volatile LibraryCatalog instance;
    private Set<Book> books;
    private final Set<LibraryObserver> observers;

    private LibraryCatalog() {
        books = new HashSet<>();
        observers = new HashSet<>();
    }

    public static LibraryCatalog getInstance() {
        if (instance == null) {
            synchronized (LibraryCatalog.class) {
                if (instance == null) {
                    instance = new LibraryCatalog();
                }
            }
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers("New book added: " + book.getTitle());
    }

    public Set<Book> getBooks() {
        return books;
    }
    public void borrowBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            books.remove(book);
            notifyObservers("Book borrowed: " + title);
        } else {
            System.out.println("Book not available: " + title);
        }
    }

    public void returnBook(Book book) {
        books.add(book);
        notifyObservers("Book returned: " + book.getTitle());
    }

    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LibraryObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (LibraryObserver observer : observers) {
            observer.update(message);
        }
    }

    public Book findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void loadBooks(String data, String format) {
        BookDataImporter importer;

        switch (format.toLowerCase()) {
            case "json":
                importer = new JSONBookImporter();
                break;
            case "csv":
                importer = new CSVBookImporter();
                break;
            case "xml":
                importer = new XMLBookImporter();
                break;
            default:
                throw new IllegalArgumentException("Unsupported format");
        }

        List<Book> newBooks = importer.importBooks(data);
        books.addAll(newBooks);
    }
}

