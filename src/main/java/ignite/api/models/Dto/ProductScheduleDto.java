package ignite.api.models.Dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

import ignite.api.models.ProductSchedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductScheduleDto {

    private LocalTime startTime;
    private LocalTime endTime;
    private int regularPrice;
    private int discountPrice;
    private DayOfWeek dayOfWeek;

    public static ProductScheduleDto toDto(ProductSchedule schedule) {
        LocalTime startTime = schedule.getStartTime();
        LocalTime endTime = schedule.getEndTime();
        int regularPrice = schedule.getRegularPrice();
        int discountPrice = schedule.getDiscountPrice();
        DayOfWeek dayOfWeek = schedule.getDayOfWeek();

        return new ProductScheduleDto(startTime, endTime, regularPrice, discountPrice, dayOfWeek);
    }
}
