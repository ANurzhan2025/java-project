package model;
import java.util.List;

public class Admin extends User {
    public Admin(String id, String username, String password, String name) {
        super(id, username, password, name);
    }

    public void addUser(User user, List<User> allUsers) {
        if (!allUsers.contains(user)) {
            allUsers.add(user);
            System.out.println("User " + user.getName() + " added to system.");
        }
    }

    public void removeUser(User user, List<User> allUsers) {
        if (allUsers.remove(user)) {
            System.out.println("User " + user.getName() + " removed.");
        }
    }
}