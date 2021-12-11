package cinema.wrappers;

import cinema.objects.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseResponse {
    private String token;
    private Seat seat;

    @JsonProperty("ticket")
    public Seat getSeat() {
        return seat;
    }
}
