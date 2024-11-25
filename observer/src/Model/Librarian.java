package Model;

public class Librarian extends User {

    public Librarian(String name) {
        super(name);
    }
    // Librarians have unlimited access to books.
    @Override
    public int getMaxBooks() {
        return Integer.MAX_VALUE;
    }
}
