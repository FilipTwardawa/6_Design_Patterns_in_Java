package Model;

public class Student extends User {

    public Student(String name) {
        super(name);
    }
    // Students can borrow up to 3 books.
    @Override
    public int getMaxBooks() {
        return 3;
    }
}
