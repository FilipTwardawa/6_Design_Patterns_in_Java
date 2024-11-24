package Singleton.BillPugh;

import Singleton.Book;
import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private List<Book> books;

    private LibraryCatalog() {
        books = new ArrayList<>();
    }

    private static class Holder {
        private static final LibraryCatalog INSTANCE = new LibraryCatalog();
    }

    public static LibraryCatalog getInstance() {
        return Holder.INSTANCE;
    }

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

