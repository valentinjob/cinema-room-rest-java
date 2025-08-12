package cinema.repositories;

import cinema.entities.SeatLocation;
import cinema.exception.TicketAlreadyPurchasedException;
import cinema.exception.WrongPurchaseTokenException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TicketsRepository {

    private final Object lock = new Object();

    private final Set<SeatLocation> tickets = new HashSet<>();

    private final Map<String, SeatLocation> ticketsByToken = new HashMap<>();

    public String addTicket(SeatLocation seatLocation) {
        Objects.requireNonNull(seatLocation, "seatLocation must not be null");

        synchronized (lock) {
            if (!tickets.add(seatLocation)) {
                throw new TicketAlreadyPurchasedException("The ticket has been already purchased!");
            }
            String purchaseToken = UUID.randomUUID().toString();
            ticketsByToken.put(purchaseToken, seatLocation);
            return purchaseToken;
        }
    }

    public SeatLocation removeTicket(String token) {
        Objects.requireNonNull(token, "token must not be null");

        synchronized (lock) {
            SeatLocation seatLocation = ticketsByToken.remove(token);
            if (seatLocation == null) {
                throw new WrongPurchaseTokenException("Wrong token!");
            }
            tickets.remove(seatLocation);
            return seatLocation;
        }
    }

    public Set<SeatLocation> getTickets() {
        return Set.copyOf(tickets);
    }
}
