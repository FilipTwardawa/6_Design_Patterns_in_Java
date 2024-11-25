package Observer;

import Model.User;

public class UserObserver implements LibraryObserver {
    private final User user;

    public UserObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + user.getName() + ": " + message);
    }
}
