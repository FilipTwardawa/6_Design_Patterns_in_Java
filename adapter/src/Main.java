import Singleton.Enum.LibraryCatalog;

public class Main {
    public static void main(String[] args) {
        var catalog = LibraryCatalog.INSTANCE;

        String jsonData = "[{\"title\":\"Java Programming\",\"author\":\"John Doe\",\"year\":2021}," +
                "{\"title\":\"Design Patterns\",\"author\":\"Erich Gamma\",\"year\":1994}]";

        String csvData = "Java Programming,John Doe,2021\nDesign Patterns,Erich Gamma,1994";

        String xmlData = "<books>" +
                "<book><title>Java Programming</title><author>John Doe</author><year>2021</year></book>" +
                "<book><title>Design Patterns</title><author>Erich Gamma</author><year>1994</year></book>" +
                "</books>";

        catalog.loadBooks(jsonData, "json");
        catalog.loadBooks(csvData, "csv");
        catalog.loadBooks(xmlData, "xml");

        catalog.getBooks().forEach(System.out::println);

    }
}