package cinema.exception;

public class WrongPurchaseTokenException extends RuntimeException {
    public WrongPurchaseTokenException(String message) {
        super(message);
    }
}
