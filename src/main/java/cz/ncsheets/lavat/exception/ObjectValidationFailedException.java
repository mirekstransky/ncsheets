package cz.ncsheets.lavat.exception;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ObjectValidationFailedException extends RuntimeException{
    public ObjectValidationFailedException() {
        super("Object validation failed");
    }
}
