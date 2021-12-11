package cinema.controller;

import cinema.objects.Cinema;
import cinema.objects.Seat;
import cinema.wrappers.PurchaseResponse;
import cinema.wrappers.ReturnResponse;
import cinema.wrappers.StatsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class UserService {

    private Cinema cinema;

    protected UserService(Cinema cinema) {
        this.cinema = cinema;
    }

    protected ResponseEntity<?> purchaseTicket(int row, int column) {

        if (row > cinema.getTotalRows() || column > cinema.getTotalColumns() || row <= 0 || column <= 0) {
            return new ResponseEntity<>(Map.of(
                    "error", "The number of a row or a column is out of bounds!"),
                    HttpStatus.BAD_REQUEST);
        }

        for (Seat seat: cinema.getAvailableSeats()) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                cinema.getAvailableSeats().remove(seat);
                cinema.getSoldSeats().add(seat);
                return new ResponseEntity<>(
                        new PurchaseResponse(seat.getToken(), seat), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(Map.of(
                    "error", "The ticket has been already purchased!"),
                    HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<?> returnTicket(String token) {

        for (Seat seat: cinema.getSoldSeats()) {
            if (seat.getToken().equals(token)) {
                cinema.getSoldSeats().remove(seat);
                cinema.getAvailableSeats().add(seat);
                return new ResponseEntity<>(new ReturnResponse(seat), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<?> getCinemaStats(String password) {
        int income = 0;
        int availableSeats;
        int soldSeats;

        if (password == null || !password.equals(PASSWORD)) {
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
        }

        // Get total income
        for (Seat seat: cinema.getSoldSeats()) {
            income += seat.getPrice();
        }
        availableSeats = cinema.getAvailableSeats().size();
        soldSeats = cinema.getSoldSeats().size();

        return new ResponseEntity<>(new StatsResponse(income, availableSeats, soldSeats), HttpStatus.OK);
    }

    // Static variables
    public static final String PASSWORD = "super_secret";
}
