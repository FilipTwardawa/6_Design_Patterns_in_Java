package Adapter;

import Book.Book;
import java.util.ArrayList;
import java.util.List;

public class JSONBookImporter implements BookDataImporter {
    @Override
    public List<Book> importBooks(String data) {
        List<Book> books = new ArrayList<>();
        data = data.replace("[", "").replace("]", "");
        String[] bookEntries = data.split("},\\{");

        for (String entry : bookEntries) {
            entry = entry.replace("{", "").replace("}", "");
            String[] fields = entry.split(",");
            String title = fields[0].split(":")[1].replace("\"", "").trim();
            String author = fields[1].split(":")[1].replace("\"", "").trim();
            int year = Integer.parseInt(fields[2].split(":")[1].trim());

            books.add(new Book(title, author, year));
        }
        return books;
    }
}
