package org.example.ExceptionHandler;

public class ProductException extends Exception {
    private static final int id = 1;
    private String errorMessage;
    public ProductException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
