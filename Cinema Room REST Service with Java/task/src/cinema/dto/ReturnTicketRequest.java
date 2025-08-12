package cinema.dto;

import jakarta.validation.constraints.NotEmpty;

public record ReturnTicketRequest(
        @NotEmpty
        String token
) {
}
