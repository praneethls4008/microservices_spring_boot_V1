package com.learning.microservices.VaccinationCenter.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

// @RestControllerAdvice handles exceptions globally across all controllers
@RestControllerAdvice
public class GlobalExceptionHandler {

    // This method catches all unhandled exceptions of type Exception.class or its subclasses
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        // Log the exception details for debugging purposes
        System.err.println("Handling global exception: " + ex.getMessage());

        System.out.println("\n\n:::::::::::::::::::::::::::::::Error:::::::::::::::::::::::::::::::");
        ex.printStackTrace();
        System.out.println(":::::::::::::::::::::::::::::::Error:::::::::::::::::::::::::::::::\n\n");

        // Create a custom error response
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An internal server error occurred",
                request.getDescription(false)
        );

        // Return a ResponseEntity with the custom body and HTTP status 500
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // You can also add specific handlers for other exceptions, for example:
    /*
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    */
}

// A simple class to structure your JSON error response
class ErrorResponse {
    private int statusCode;
    private String message;
    private String details;

    public ErrorResponse(int statusCode, String message, String details) {
        this.statusCode = statusCode;
        this.message = message;
        this.details = details;
    }

    // Getters and setters (or use a Java record)
    public int getStatusCode() { return statusCode; }
    public String getMessage() { return message; }
    public String getDetails() { return details; }
}
