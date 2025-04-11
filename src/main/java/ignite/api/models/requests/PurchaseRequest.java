package ignite.api.models.requests;

import java.time.DayOfWeek;
import java.time.LocalTime;

import ignite.api.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {

    private String name;
    private String purchaser;
    private String payMethod;
    private int payment;

    private LocalTime startTime;
    private LocalTime endTime;
    private DayOfWeek dayOfWeek;
    private int regularPrice;
    private int discountPrice;
}
