package cinema.controllers;

import cinema.dto.*;
import cinema.exception.IncorrectPasswordException;
import cinema.services.CinemaRoomService;
import cinema.services.PurchaseService;
import cinema.services.StatsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class CinemaController {

    private final CinemaRoomService roomService;
    private final PurchaseService purchaseService;
    private final StatsService statsService;

    public CinemaController(CinemaRoomService roomService, PurchaseService purchaseService, StatsService statsService) {
        this.roomService = roomService;
        this.purchaseService = purchaseService;
        this.statsService = statsService;
    }

    @GetMapping("/seats")
    public CinemaRoom getSeats() {
        return roomService.getCinemaRoomMapping();
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam String password) {
        Objects.requireNonNull(password);

        if (!"super_secret".equals(password)) {
            throw new IncorrectPasswordException("The password is wrong!");
        }
        return ResponseEntity.ok(statsService.getStats());
    }


    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@Valid @RequestBody PurchaseRequest request) {
        PurchaseResponse purchasedTicket = purchaseService.purchaseTicket(request);
        return ResponseEntity.ok(purchasedTicket);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@Valid @RequestBody ReturnTicketRequest request) {
        TicketDto ticketDto = purchaseService.returnTicket(request.token());
        return ResponseEntity.ok(new ReturnTicketResponse(ticketDto));
    }
}
