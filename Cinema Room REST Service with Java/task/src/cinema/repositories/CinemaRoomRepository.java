package cinema.repositories;

import cinema.dto.CinemaRoom;
import cinema.dto.TicketDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaRoomRepository {

    private final static int ROOM_SIZE = 9;
    private final SeatsRepository seatsRepository;

    public CinemaRoomRepository(SeatsRepository seatsRepository) {
        this.seatsRepository = seatsRepository;
    }

    public CinemaRoom getCinemaRoom() {

        List<TicketDto> seats = seatsRepository.getAllSeats()
                .entrySet()
                .stream()
                .flatMap(row -> row.getValue().entrySet()
                        .stream()
                        .map(column -> new TicketDto(row.getKey(), column.getKey(), column.getValue())))
                .toList();

        return new CinemaRoom(ROOM_SIZE, ROOM_SIZE, seats);
    }
}
