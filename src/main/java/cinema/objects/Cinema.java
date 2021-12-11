package cinema.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

public class Cinema {

    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;
    private List<Seat> soldSeats;

    public Cinema(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = generateSeats();
        this.soldSeats = new LinkedList<>();
    }

    //Getters

    @JsonProperty("total_rows")
    public int getTotalRows() {
        return totalRows;
    }

    @JsonProperty("total_columns")
    public int getTotalColumns() {
        return totalColumns;
    }

    @JsonProperty("available_seats")
    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    @JsonIgnore
    public List<Seat> getSoldSeats() {
        return soldSeats;
    }

    private LinkedList<Seat> generateSeats() {
        LinkedList<Seat> seats = new LinkedList<>();
        int row;
        int col;
        int price;

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                row = i + 1;
                col = j + 1;
                price = row <= NUM_EXPENSIVE_ROWS ? PRICE_EXPENSIVE : PRICE_CHEAP;
                seats.add(new Seat(row, col, price));
            }
        }

        return seats;
    }


    // static final variables
    private static final int PRICE_EXPENSIVE = 10;
    private static final int PRICE_CHEAP = 8;
    private static final int NUM_EXPENSIVE_ROWS = 4;
}
