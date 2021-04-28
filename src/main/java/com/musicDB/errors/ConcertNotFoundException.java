package main.java.com.musicDB.errors;

public class ConcertNotFoundException extends RuntimeException{
    public ConcertNotFoundException(String message) {
        super(message);
    }

    public ConcertNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConcertNotFoundException(Throwable cause) {
        super(cause);
    }
}
