package ignite.api.models;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ignite.api.config.BaseEntity;
import ignite.api.models.Dto.ProductScheduleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@AllArgsConstructor
public class ProductSchedule extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private LocalTime startTime;
    private LocalTime endTime;
    private int regularPrice;
    private int discountPrice;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    public ProductSchedule(Product product, ProductScheduleDto dto) {
        this.product = product;
        this.startTime = dto.getStartTime();
        this.endTime = dto.getEndTime();
        this.regularPrice = dto.getRegularPrice();
        this.discountPrice = dto.getDiscountPrice();
        this.dayOfWeek = dto.getDayOfWeek();
    }
}
