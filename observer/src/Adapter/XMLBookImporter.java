package Adapter;

import Book.Book;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;

public class XMLBookImporter implements BookDataImporter {
    @Override
    public List<Book> importBooks(String data) {
        List<Book> books = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new java.io.StringReader(data));
            Document doc = builder.parse(is);

            NodeList bookNodes = doc.getElementsByTagName("book");

            for (int i = 0; i < bookNodes.getLength(); i++) {
                Node bookNode = bookNodes.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                    int year = Integer.parseInt(bookElement.getElementsByTagName("year").item(0).getTextContent());
                    books.add(new Book(title, author, year));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
