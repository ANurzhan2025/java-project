package model;

import exceptions.LowHIndexException;
import java.util.Comparator;
import java.util.List;

public interface Researcher {

    String getName();
    int getHIndex();
    List<ResearchPaper> getPapers();

    default void printPapers(Comparator<ResearchPaper> comparator) {
        List<ResearchPaper> papers = getPapers();
        if (papers.isEmpty()) {
            System.out.println(getName() + " has no published papers.");
            return;
        }
        System.out.println("=== Papers by " + getName() + " (h-index: " + getHIndex() + ") ===");
        papers.stream()
                .sorted(comparator)
                .forEach(System.out::println);
        System.out.println();
    }

    default int getTotalCitations() {
        return getPapers().stream()
                .mapToInt(ResearchPaper::getCitations)
                .sum();
    }

    default void validateAsSupervisor() throws LowHIndexException {
        if (getHIndex() < 3) {
            throw new LowHIndexException(getName(), getHIndex());
        }
    }
}