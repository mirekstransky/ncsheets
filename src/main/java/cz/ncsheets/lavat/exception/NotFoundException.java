package cz.ncsheets.lavat.exception;

import java.util.Objects;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String name, Long id) {
        super("The "+ name +" id '" + id + "' does not exist in our records");
    }

}
