package model;

import java.time.LocalDate;
import java.util.List;

public class ResearchPaper {

    private String title;
    private List<String> authors;
    private String journal;
    private LocalDate date;
    private int citations;
    private int pages;
    private String doi;
    private String abstractText;
    private String keywords;

    public ResearchPaper(String title, List<String> authors, String journal,
                         LocalDate date, int citations, int pages,
                         String doi, String abstractText, String keywords) {
        this.title        = title;
        this.authors      = authors;
        this.journal      = journal;
        this.date         = date;
        this.citations    = citations;
        this.pages        = pages;
        this.doi          = doi;
        this.abstractText = abstractText;
        this.keywords     = keywords;
    }

    public String getTitle()         { return title; }
    public List<String> getAuthors() { return authors; }
    public String getJournal()       { return journal; }
    public LocalDate getDate()       { return date; }
    public int getCitations()        { return citations; }
    public int getPages()            { return pages; }
    public String getDoi()           { return doi; }
    public String getAbstractText()  { return abstractText; }
    public String getKeywords()      { return keywords; }

    public void setCitations(int citations) { this.citations = citations; }

    @Override
    public String toString() {
        return String.format(
                "  [%s] \"%s\"\n" +
                        "    Authors  : %s\n" +
                        "    Journal  : %s | Pages: %d | Citations: %d\n" +
                        "    DOI      : %s",
                date, title,
                String.join(", ", authors),
                journal, pages, citations,
                doi
        );
    }
}