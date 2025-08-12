package cinema.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record PurchaseRequest(
        @Min(value = 1)
        @Max(value = 9)
        int row,
        @Min(value = 1)
        @Max(value = 9)
        int column
) {
}
