package ignite.api.models;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import ignite.api.config.BaseEntity;

@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    private Product product;
    private LocalTime startTime;
    private LocalTime endTime;
    private int regularPrice;
    private int discountPrice;
    private DayOfWeek dayOfWeek;
}
