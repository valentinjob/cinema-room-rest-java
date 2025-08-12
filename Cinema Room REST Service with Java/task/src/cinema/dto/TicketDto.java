package cinema.dto;

import lombok.Data;

@Data
public class TicketDto {
    private final int row;
    private final int column;
    private final int price;
}
