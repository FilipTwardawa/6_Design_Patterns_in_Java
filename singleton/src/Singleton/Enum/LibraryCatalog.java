package Singleton.Enum;

import Singleton.Book;
import java.util.ArrayList;
import java.util.List;

public enum LibraryCatalog {
    INSTANCE;

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
}

