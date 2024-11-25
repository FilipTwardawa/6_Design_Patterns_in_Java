package Adapter;

import Book .Book;
import java.util.ArrayList;
import java.util.List;

public class CSVBookImporter implements BookDataImporter {
    @Override
    public List<Book> importBooks(String data) {
        List<Book> books = new ArrayList<>();
        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            books.add(new Book(fields[0], fields[1], Integer.parseInt(fields[2])));
        }
        return books;
    }
}
