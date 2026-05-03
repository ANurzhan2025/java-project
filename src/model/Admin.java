package model;

import java.util.List;

public class Admin extends Employee {
    
    public Admin(String id, String name, String password) {
        super(id, name, password);
    }

    public void addUser(List<User> userList, User newUser) {
        userList.add(newUser);
        System.out.println("User " + newUser.getName() + " added successfully.");
    }

    public void removeUser(List<User> userList, User user) {
        if (userList.remove(user)) {
            System.out.println("User removed.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void updateUser(User user, String newName) {
        user.setName(newName);
        System.out.println("User updated.");
    }

    @Override
    public String toString() {
        return "Admin: " + getName() + " " + getSurname();
    }
}