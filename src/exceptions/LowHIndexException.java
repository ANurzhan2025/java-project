package exceptions;

public class LowHIndexException extends Exception {
    public LowHIndexException(String supervisorName, int hIndex) {
        super("'" + supervisorName + "' cannot be assigned as supervisor. H-index is " + hIndex + " (minimum required: 3).");
    }
}