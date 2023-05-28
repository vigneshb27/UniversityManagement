package exceptions;

public class FileReadWriteException extends Exception {
    public String message;

    public FileReadWriteException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
