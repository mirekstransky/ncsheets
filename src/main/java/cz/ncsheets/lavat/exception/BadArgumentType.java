package cz.ncsheets.lavat.exception;

public class BadArgumentType extends RuntimeException{
    public BadArgumentType(Long id) {
        super("Bad argument: " + id);
    }
}
