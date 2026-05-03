package model;

public abstract class Employee extends User {
    private double salary;

    public Employee(String id, String name, String password) {
        super(id, name, password);
    }

    public Employee(String id, String name, String surname, String email, String password) {
        super(id, name, surname, email, password);
    }
}