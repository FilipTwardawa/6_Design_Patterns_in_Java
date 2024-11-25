package Factory;

import Model.*;

public class UserFactory {

    public static User createUser(String userType, String name) {
        switch (userType.toLowerCase()) {
            case "student":
                return new Student(name);
            case "teacher":
                return new Teacher(name);
            case "librarian":
                return new Librarian(name);
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }
}
