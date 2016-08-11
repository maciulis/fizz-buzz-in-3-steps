package uk.gov.ho.fizzbuzz;

public class FizzBuzzException extends RuntimeException {
    public FizzBuzzException(String message, Throwable e) {
        super(message, e);
    }
}
