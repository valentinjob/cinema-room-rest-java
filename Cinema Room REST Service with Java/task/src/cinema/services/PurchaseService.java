package cinema.services;

import cinema.dto.*;
import cinema.entities.SeatLocation;
import cinema.repositories.SeatsRepository;
import cinema.repositories.TicketsRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    private final TicketsRepository ticketsRepository;
    private final SeatsRepository seatsRepository;

    private final SeatMapper seatMapper;

    public PurchaseService(TicketsRepository ticketsRepository, SeatsRepository seatsRepository, SeatMapper seatMapper) {
        this.ticketsRepository = ticketsRepository;
        this.seatsRepository = seatsRepository;
        this.seatMapper = seatMapper;
    }

    public PurchaseResponse purchaseTicket(PurchaseRequest request) {
        SeatLocation seatLocation = new SeatLocation(request.row(), request.column());

        String purchaseToken = ticketsRepository.addTicket(seatLocation);
        TicketDto ticket = seatMapper.seatToDto(seatsRepository.getSeat(seatLocation.row(), seatLocation.column()));
        return new PurchaseResponse(ticket, purchaseToken);
    }

    public TicketDto returnTicket(String token) {
        SeatLocation seatLocation = ticketsRepository.removeTicket(token);

        return seatMapper.seatToDto(seatsRepository.getSeat(seatLocation.row(), seatLocation.column()));
    }



}
