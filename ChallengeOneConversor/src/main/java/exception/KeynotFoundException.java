package exception;

/**
 * Exception thrown when a key is not found.
 */
public class KeynotFoundException extends Exception{

    /**
     * Constructs a new KeynotFoundException with the specified detail message.
     *
     * @param message the detail message.
     */
    public KeynotFoundException(String message) {
        super(message);
    }
}
