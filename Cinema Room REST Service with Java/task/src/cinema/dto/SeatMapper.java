package cinema.dto;

import cinema.entities.Seat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    Seat requestToSeat(PurchaseRequest request);

    TicketDto seatToDto(Seat seat);
}
