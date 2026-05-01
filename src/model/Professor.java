package model;

import java.util.ArrayList;
import java.util.List;

public class Professor implements Researcher {

    private String name;
    private int hIndex;
    private List<ResearchPaper> papers;

    public Professor(String name, int hIndex) {
        this.name   = name;
        this.hIndex = hIndex;
        this.papers = new ArrayList<>();
    }

    public void addPaper(ResearchPaper paper) {
        papers.add(paper);
    }

    @Override public String getName()                { return name; }
    @Override public int getHIndex()                 { return hIndex; }
    @Override public List<ResearchPaper> getPapers() { return papers; }

    @Override
    public String toString() { return "Professor(" + name + ")"; }
}