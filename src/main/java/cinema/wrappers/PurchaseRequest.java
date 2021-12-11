package cinema.wrappers;

import lombok.Data;

@Data
public class PurchaseRequest {
    private int row;
    private int column;
}
