package cinema.services;

import cinema.dto.StatsResponse;
import cinema.repositories.SeatsRepository;
import cinema.repositories.TicketsRepository;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private final TicketsRepository ticketsRepository;
    private final SeatsRepository seatsRepository;

    public StatsService(TicketsRepository ticketsRepository, SeatsRepository seatsRepository) {
        this.ticketsRepository = ticketsRepository;
        this.seatsRepository = seatsRepository;
    }

    public StatsResponse getStats() {

        var tickets = ticketsRepository.getTickets();

        int income = tickets.stream()
                .mapToInt(it -> seatsRepository.getSeat(it.row(), it.column()).price())
                .sum();
        int available = seatsRepository.getAllSeatsCount() - tickets.size();
        int purchased = tickets.size();

        return new StatsResponse(income, available, purchased);
    }
}
