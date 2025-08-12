package cinema.exception;

public class SeatOutOfBoundsException extends RuntimeException {
    public SeatOutOfBoundsException(String message) {
        super(message);
    }
}
