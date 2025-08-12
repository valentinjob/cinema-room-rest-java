package cinema.repositories;

import cinema.entities.Seat;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SeatsRepository {

    private static final int GRID_SIZE = 9;
    private static final int PREMIUM_PRICE = 10;
    private static final int REGULAR_PRICE = 8;
    private static final int PREMIUM_ROWS = 4;


    private final Map<Integer, Map<Integer, Integer>> seats = new ConcurrentHashMap<>() {{
        for (int i = 1; i <= GRID_SIZE; i++) {
            Map<Integer, Integer> column = new ConcurrentHashMap<>();
            for (int j = 1; j <= GRID_SIZE; j++) {
                column.put(j, getPriceForSeat(i));
            }
            put(i, column);
        }
    }};

    public Map<Integer, Map<Integer, Integer>> getAllSeats() {
        return seats;
    }

    public int getAllSeatsCount() {
        return GRID_SIZE * GRID_SIZE;
    }

    public Seat getSeat(int row, int column) {
        validateSeatLocation(row, column);
        return new Seat(row, column, seats.get(row).get(column));
    }

    private void validateSeatLocation(int row, int column) {
        if (row < 1 || row > GRID_SIZE || column < 1 || column > GRID_SIZE) {
            throw new IllegalArgumentException("The number of a row or a column is out of bounds!");
        }
    }


    private int getPriceForSeat(int rowNumber) {
        return rowNumber <= PREMIUM_ROWS ? PREMIUM_PRICE : REGULAR_PRICE;
    }
}
