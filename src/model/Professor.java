package model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Employee implements Researcher {

    private String name;
    private int hIndex;
    private List<ResearchPaper> papers;
    private List<Course> courses; 

    public Professor(String name, int hIndex) {
        super(name, name, "defaultPass"); 
        this.name   = name;
        this.hIndex = hIndex;
        this.papers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addPaper(ResearchPaper paper) {
        papers.add(paper);
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override public String getName()                { return name; }
    @Override public int getHIndex()                 { return hIndex; }
    @Override public List<ResearchPaper> getPapers() { return papers; }

    @Override
    public String toString() { return "Professor(" + name + ")"; }
}