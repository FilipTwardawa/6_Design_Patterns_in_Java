package Adapter;

import Book.Book;
import java.util.List;

public interface BookDataImporter {
    List<Book> importBooks(String data);
}

