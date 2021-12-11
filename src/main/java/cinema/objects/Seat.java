package cinema.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;
import java.util.Map;

public class Seat {

    private boolean available;
    private int row;
    private int column;
    private int price;
    private String token;

    public Seat(int row, int col, int price) {
        this.available = true;
        this.row = row;
        this.column = col;
        this.price = price;
        this.token = UUID.randomUUID().toString();
    }

    // Setters
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Getters
    @JsonIgnore
    public boolean isAvailable() {
        return this.available;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int getPrice() {
        return price;
    }

    @JsonIgnore
    public String getToken() {
        return token;
    }


    // Other methods
    public Map<String, ?> returnTicket() {
        this.setAvailable(true);
        return Map.of(
                "returned_ticket", Map.of(
                        "row", this.getRow(),
                        "column", this.getColumn(),
                        "price", this.getPrice()
                )
        );
    }

}
