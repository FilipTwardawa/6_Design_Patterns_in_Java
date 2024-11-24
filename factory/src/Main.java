import Factory.UserFactory;
import Model.Book;
import Model.User;
import Service.LibraryService;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();

        // Adding books
        libraryService.addBook(new Book("Clean Code", "Robert C. Martin", 2008));
        libraryService.addBook(new Book("Effective Java", "Joshua Bloch", 2018));
        libraryService.addBook(new Book("Design Patterns", "Erich Gamma", 1994));
        libraryService.addBook(new Book("Design Home", "Alfred Koch", 2001));


        // Creation of users
        User student = UserFactory.createUser("student", "Alice");
        User teacher = UserFactory.createUser("teacher", "Bob");
        User librarian = UserFactory.createUser("librarian", "Charlie");

        // User registration
        libraryService.addUser(student);
        libraryService.addUser(teacher);
        libraryService.addUser(librarian);

        // Display of library status
        libraryService.displayAvailableBooks();
        libraryService.displayUsers();

        // Book loans
        libraryService.borrowBook(student, new Book("Clean Code", "Robert C. Martin", 2008));
        libraryService.borrowBook(teacher, new Book("Effective Java", "Joshua Bloch", 2018));
        libraryService.borrowBook(librarian, new Book("Design Patterns", "Erich Gamma", 1994));

        // Condition after hire
        libraryService.displayAvailableBooks();
    }
}