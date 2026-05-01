package comparators;

import model.ResearchPaper;
import java.util.Comparator;

public class PaperComparators {

    public static final Comparator<ResearchPaper> BY_DATE =
            Comparator.comparing(ResearchPaper::getDate);

    public static final Comparator<ResearchPaper> BY_DATE_DESC =
            Comparator.comparing(ResearchPaper::getDate).reversed();

    public static final Comparator<ResearchPaper> BY_CITATIONS_DESC =
            Comparator.comparingInt(ResearchPaper::getCitations).reversed();

    public static final Comparator<ResearchPaper> BY_CITATIONS =
            Comparator.comparingInt(ResearchPaper::getCitations);

    public static final Comparator<ResearchPaper> BY_PAGES =
            Comparator.comparingInt(ResearchPaper::getPages);

    public static final Comparator<ResearchPaper> BY_PAGES_DESC =
            Comparator.comparingInt(ResearchPaper::getPages).reversed();

    private PaperComparators() {}
}