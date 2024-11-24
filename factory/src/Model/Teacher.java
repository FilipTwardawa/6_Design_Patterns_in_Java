package Model;

public class Teacher extends User {

    public Teacher(String name) {
        super(name);
    }
    // Teachers can borrow up to 10 books.
    @Override
    public int getMaxBooks() {
        return 10;
    }
}
