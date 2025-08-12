package cinema.services;

import cinema.dto.CinemaRoom;
import cinema.repositories.CinemaRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class CinemaRoomService {

    private final CinemaRoomRepository repo;

    public CinemaRoomService(CinemaRoomRepository repo) {
        this.repo = repo;
    }

    public CinemaRoom getCinemaRoomMapping() {
        return this.repo.getCinemaRoom();
    }
}
