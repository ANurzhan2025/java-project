package model;

import java.util.List;

public class Manager extends Employee {
    private ManagerType type;

    public Manager(String id, String name, String password, ManagerType type) {
        super(id, name, password);
        this.type = type;
    }

    public void viewStudentInfo(Student student) {
        System.out.println("--- Student Info (Manager View) ---");
        System.out.println("Name: " + student.getName() + " | Year: " + student.getYearOfStudy());
    }

    public void assignCourse(Professor professor, Course course) {
        professor.getCourses().add(course);
        System.out.println("✅ Manager: Assigned " + course.getCourseName() + " to " + professor.getName());
    }

    public void generatePerformanceReport(List<Student> students) {
        System.out.println("--- Performance Report ---");
        for (Student s : students) {
            System.out.println("Student: " + s.getName() + " | Registered Credits: " + s.getCourses().size());
        }
    }

    @Override
    public String toString() {
        return "Manager (" + type + "): " + getName();
    }
}