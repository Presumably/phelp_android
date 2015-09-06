package ussdmaster.divum.phelp.exception;

public final class ConnectorException extends Exception {

    public ConnectorException(String message) {
        super(message);
    }

    public ConnectorException(String message, Exception e) {
        super(message, e);
    }

}
