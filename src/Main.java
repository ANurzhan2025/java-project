import comparators.PaperComparators;
import exceptions.CreditLimitExceededException;
import exceptions.LowHIndexException;
import exceptions.NonResearcherException;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Professor drSmith  = new Professor("Dr. Smith", 7);
        Professor drLow    = new Professor("Dr. Low",   1);
        GradStudent alice  = new GradStudent("Alice",   4);
        GradStudent bob    = new GradStudent("Bob",     2);

        ResearchPaper p1 = new ResearchPaper(
                "Deep Learning for NLP",
                Arrays.asList("Dr. Smith", "Alice"),
                "IEEE Transactions on Neural Networks",
                LocalDate.of(2019, 3, 15),
                320, 12, "10.1109/TNN.2019.001", "Abstract A", "AI, NLP"
        );
        ResearchPaper p2 = new ResearchPaper(
                "Federated Learning at Scale",
                Arrays.asList("Dr. Smith"),
                "Nature Machine Intelligence",
                LocalDate.of(2022, 7, 1),
                85, 8, "10.1038/NMI.2022.042", "Abstract B", "FL, Privacy"
        );

        drSmith.addPaper(p1);
        drSmith.addPaper(p2);
        alice.addPaper(p1);

        System.out.println("\n========= SYSTEM TEST: STUDENTS & COURSES =========");
        
        Course oop = new Course("CS201", "OOP", 5);
        Course db = new Course("CS202", "Databases", 6);
        Course math = new Course("MT101", "Calculus", 8);
        Course physics = new Course("PH101", "Physics", 5);

        Student me = new Student("S123", "doskabol", "pass123", "Doszhan", 4);

        System.out.println("--- Testing Course Registration (Limit 21) ---");
        try {
            me.registerForCourse(oop);
            me.registerForCourse(db);
            me.registerForCourse(math);
            System.out.println("✅ Registered: 19 credits.");
            
            System.out.println("Attempting to add Physics (5 credits)...");
            me.registerForCourse(physics);
            
        } catch (CreditLimitExceededException e) {
            System.out.println("❌ " + e.getMessage());
        }

        System.out.println("\n--- Testing Supervisor Assignment (4th Year Rule) ---");
        try {
            me.setSupervisor(drSmith);
            System.out.println("✅ " + drSmith.getName() + " assigned.");
        } catch (LowHIndexException e) {
            System.out.println("❌ " + e.getMessage());
        }

        System.out.println("\n========= SYSTEM TEST: RESEARCH PROJECTS =========");
        ResearchProject project = new ResearchProject("AI in Healthcare");
        project.addPaper(p1);

        try {
            project.addParticipant(drSmith);
            project.addParticipant(alice);
            project.addParticipant("Simple User"); 
        } catch (NonResearcherException e) {
            System.out.println("❌ " + e.getMessage());
        }

        System.out.println("\n--- Final Student Status ---");
        me.viewCourses();
        me.viewMarks();

        System.out.println("\n--- Researcher Ranking (Manager View) ---");
        List<Researcher> allResearchers = new ArrayList<>(Arrays.asList(drSmith, alice, bob));
        ResearchManager manager = new ResearchManager(allResearchers);
        manager.printResearcherRanking();
    }
}
```[cite: 1, 2]