package cz.ncsheets.lavat;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class MVCexceptionHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    public String handleNoResourceFoundException() {
        return "error_view";
    }
}