package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    private String courseCode;
    private String name;
    private int credits;
    private List<Professor> instructors; 

    public Course(String courseCode, String name, int credits) {
        this.courseCode = courseCode;
        this.name = name;
        this.credits = credits;
        this.instructors = new ArrayList<>();
    }

    public String getCourseCode() { return courseCode; }
    public String getName() { return name; }
    public String getCourseName() { return name; }
    public int getCredits() { return credits; }
    
    public void addInstructor(Professor professor) {
        this.instructors.add(professor);
    }

    public List<Professor> getInstructors() {
        return instructors;
    }

    @Override
    public String toString() {
        return name + " (" + courseCode + ") - " + credits + " credits";
    }
}