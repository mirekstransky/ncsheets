package cz.ncsheets.lavat.exception;

public class DuplicateObjectException extends RuntimeException{
    public DuplicateObjectException() {
        super("Object is duplicate");
    }
    public DuplicateObjectException(String message) {
        super(message);
    }
    public DuplicateObjectException(int i) {
        super("Object " + i + " is duplicate");
    }
}
