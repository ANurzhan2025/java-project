package exceptions;

public class NonResearcherException extends Exception {
    public NonResearcherException(String personName) {
        super("'" + personName + "' is not a Researcher and cannot join a ResearchProject.");
    }
}