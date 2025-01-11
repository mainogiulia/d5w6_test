package it.epicode.d5w6_test.exceptions;

public class SameDateException extends RuntimeException{
    public SameDateException(String message) {
        super(message);
    }
}
