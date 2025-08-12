package cinema.exception;

public class TicketAlreadyPurchasedException extends RuntimeException {
    public TicketAlreadyPurchasedException(String message) {
        super(message);
    }
}
