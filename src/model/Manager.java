package model;
import java.util.List;

public class Manager extends User {
    private ManagerType type;

    public Manager(String id, String username, String password, String name, ManagerType type) {
        super(id, username, password, name);
        this.type = type;
    }

    public void approveRegistration(Student student, Course course) {
        System.out.println("Manager " + getName() + " approved registration for " + student.getName());
    }

    public void assignCourseToProfessor(Course course, Professor professor) {
        System.out.println("Course " + course.getName() + " assigned to " + professor.getName());
    }

    public void generatePerformanceReport(List<Student> students) {
        System.out.println("--- Performance Report ---");
        for (Student s : students) {
            System.out.println("Student: " + s.getName() + " | Year: " + s.getYearOfStudy());
        }
    }
}