package exceptions;

public class InvalidInputException extends Exception {
    public String message;

    public InvalidInputException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
