package cinema.controller;

import cinema.objects.Cinema;
import cinema.wrappers.PurchaseRequest;
import cinema.wrappers.ReturnRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class Controller {

    Cinema cinema = new Cinema(NUM_OF_ROWS, NUM_OF_COLUMNS);
    UserService service = new UserService(cinema);

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody PurchaseRequest purchaseRequest) {
        return service.purchaseTicket(purchaseRequest.getRow(), purchaseRequest.getColumn());
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody ReturnRequest returnRequest) {
        return service.returnTicket(returnRequest.getToken());
    }

    @PostMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam(value = "password", required = false) String password) {
        return service.getCinemaStats(password);
    }


    // Static final variables
    private static final int NUM_OF_ROWS = 9;
    private static final int NUM_OF_COLUMNS = 9;

}
