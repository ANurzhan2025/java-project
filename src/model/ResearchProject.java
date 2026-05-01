package model;

import exceptions.NonResearcherException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResearchProject {

    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Researcher> participants;

    public ResearchProject(String topic) {
        this.topic           = topic;
        this.publishedPapers = new ArrayList<>();
        this.participants    = new ArrayList<>();
    }

    public void addParticipant(Object person) throws NonResearcherException {
        if (!(person instanceof Researcher)) {
            throw new NonResearcherException(person.toString());
        }
        Researcher researcher = (Researcher) person;
        if (!participants.contains(researcher)) {
            participants.add(researcher);
            System.out.println("✔ " + researcher.getName() + " joined project: \"" + topic + "\"");
        }
    }

    public void addPaper(ResearchPaper paper) {
        publishedPapers.add(paper);
    }

    public void printPapers(Comparator<ResearchPaper> comparator) {
        System.out.println("=== Papers in project: \"" + topic + "\" ===");
        if (publishedPapers.isEmpty()) {
            System.out.println("  (no papers published yet)");
            return;
        }
        publishedPapers.stream()
                .sorted(comparator)
                .forEach(System.out::println);
        System.out.println();
    }

    public void printParticipants() {
        System.out.println("=== Participants in \"" + topic + "\" ===");
        participants.forEach(r ->
                System.out.println("  - " + r.getName() + " (h-index: " + r.getHIndex() + ")"));
        System.out.println();
    }

    public String getTopic()                         { return topic; }
    public List<ResearchPaper> getPublishedPapers()  { return publishedPapers; }
    public List<Researcher> getParticipants()        { return participants; }
}