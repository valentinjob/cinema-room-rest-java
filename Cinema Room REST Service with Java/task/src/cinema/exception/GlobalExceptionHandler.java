package cinema.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.UnsatisfiedRequestParameterException;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(TicketAlreadyPurchasedException.class)
    public ResponseEntity<?> handleTicketAlreadyPurchased(TicketAlreadyPurchasedException e) {
        return ResponseEntity.badRequest()
                .body(Map.of("error", e.getMessage()));
    }
    @ExceptionHandler(WrongPurchaseTokenException.class)
    public ResponseEntity<?> handleWrongPurchaseToken(WrongPurchaseTokenException e) {
        return ResponseEntity.badRequest()
                .body(Map.of("error", e.getMessage()));
    }
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<?> handleWrongPurchaseToken(IncorrectPasswordException e) {
        return ResponseEntity.status(401)
                .body(Map.of("error", e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .badRequest()
                .body(Map.of("error", "The number of a row or a column is out of bounds!"));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleValidationExceptions(MissingServletRequestParameterException ex) {
        return ResponseEntity
                .status(401)
                .body(Map.of("error", "The password is wrong!"));
    }
}
