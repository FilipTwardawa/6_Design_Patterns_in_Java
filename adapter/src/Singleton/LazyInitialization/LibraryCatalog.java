package Singleton.LazyInitialization;

import Adapter.BookDataImporter;
import Adapter.CSVBookImporter;
import Adapter.JSONBookImporter;
import Adapter.XMLBookImporter;
import Book.Book;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LibraryCatalog {
    private static LibraryCatalog instance;
    private Set<Book> books;

    private LibraryCatalog() {
        books = new HashSet<>();
    }

    public static LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Set<Book> getBooks() {
        return books;
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
        newBooks.forEach(this::addBook);
    }
}
