package cz.ncsheets.lavat;

import cz.ncsheets.lavat.exception.*;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage("Failed to read request");
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorResponse error = new ErrorResponse();
        error.setMessage("Validation failed for argument");
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handlerException(NotFoundException ex) {

        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getLocalizedMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage("No resource found");
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler(NoResourceFoundException.class)
//    public ResponseEntity<Object> handlerException(NoResourceFoundException ex) {
//
//        ErrorResponse error = new ErrorResponse();
//        error.setMessage("No resource found");
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(DuplicateObjectException.class)
    public ResponseEntity<Object> handlerException(DuplicateObjectException ex) {

        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getLocalizedMessage());
        error.setStatus(HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ObjectValidationFailedException.class)
    public ResponseEntity<Object> handlerException(ObjectValidationFailedException ex) {

        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getLocalizedMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ObjectIDisNotNull.class)
    public ResponseEntity<Object> handlerException(ObjectIDisNotNull ex) {

        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getLocalizedMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadArgumentType.class)
    public ResponseEntity<Object> handlerException(BadArgumentType ex) {

        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getLocalizedMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handlerException(Exception ex) {

        ErrorResponse error = new ErrorResponse();
        error.setMessage("Illegal input value");
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
