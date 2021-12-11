package cinema.wrappers;

import cinema.objects.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnResponse {

    private Seat seat;

    @JsonProperty("returned_ticket")
    public Seat getSeat() {
        return seat;
    }
}
