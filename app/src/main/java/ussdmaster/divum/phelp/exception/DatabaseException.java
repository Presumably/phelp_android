package ussdmaster.divum.phelp.exception;

public final class DatabaseException extends Exception {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Exception e) {
        super(message, e);
    }
}
