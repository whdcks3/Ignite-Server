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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "schedule")
@Getter
@Setter
public class ProductSchedule extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private LocalTime startTime;
    private LocalTime endTime;
    private int regularPrice;
    private int discountPrice;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
}
