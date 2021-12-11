package cinema.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class StatsResponse {
    private int currentIncome;
    private int availableSeats;
    private int purchasedTickets;

    @JsonProperty("current_income")
    public int getCurrentIncome() {
        return currentIncome;
    }

    @JsonProperty("number_of_available_seats")
    public int getAvailableSeats() {
        return availableSeats;
    }

    @JsonProperty("number_of_purchased_tickets")
    public int getPurchasedTickets() {
        return purchasedTickets;
    }
}
