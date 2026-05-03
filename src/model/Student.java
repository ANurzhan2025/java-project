package model;

import exceptions.CreditLimitExceededException;
import exceptions.LowHIndexException;
import java.io.Serializable;
import java.util.*;

public class Student extends User implements Serializable { 
    private int yearOfStudy;
    private int totalCredits;
    private List<Course> registeredCourses;
    private Map<Course, Mark> marks;
    private Researcher researchSupervisor; 

    public Student(String id, String username, String password, String name, int yearOfStudy) {
        super(id, username, password, name); 
        this.yearOfStudy = yearOfStudy;
        this.totalCredits = 0;
        this.registeredCourses = new ArrayList<>();
        this.marks = new HashMap<>();
    }

    public void registerForCourse(Course course) throws CreditLimitExceededException {
        if (this.totalCredits + course.getCredits() > 21) {
            throw new CreditLimitExceededException("Cannot register: total credits would exceed 21!");[cite: 1]
        }
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            marks.put(course, new Mark()); // Инициализируем пустую оценку[cite: 1]
            this.totalCredits += course.getCredits();
        }
    }

    
    public void setSupervisor(Researcher supervisor) throws LowHIndexException {
        if (this.yearOfStudy == 4) {
            supervisor.validateAsSupervisor(); 
            this.researchSupervisor = supervisor;
        } else {
            System.out.println("Only 4th year students have a research supervisor.");
        }
    }

    public void viewCourses() {
        System.out.println("Courses for " + getName() + ":");
        registeredCourses.forEach(System.out::println);
    }

    public void viewMarks() {
        System.out.println("Marks for " + getName() + ":");
        marks.forEach((course, mark) -> System.out.println(course.getName() + ": " + mark));
    }

    public int getYearOfStudy() { return yearOfStudy; }
}