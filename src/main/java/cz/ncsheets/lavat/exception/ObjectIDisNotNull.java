package cz.ncsheets.lavat.exception;

public class ObjectIDisNotNull extends RuntimeException{

    public ObjectIDisNotNull()
    {
        super("The object ID is not null, unable to set ID");
    }




}
