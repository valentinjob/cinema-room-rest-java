package cinema.dto;

import lombok.Data;

import java.util.List;

@Data
public class CinemaRoom {
    private int rows;
    private int columns;

    private List<TicketDto> seats;

    public CinemaRoom(int rows, int columns, List<TicketDto> seats) {
        this.rows = rows;
        this.columns = columns;
        this.seats = seats;
    }
}
