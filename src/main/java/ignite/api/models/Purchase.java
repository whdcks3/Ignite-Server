package ignite.api.models;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ignite.api.config.BaseEntity;
import ignite.api.models.enums.ReservationStatus;
import ignite.api.models.requests.ProductRequest;
import ignite.api.models.requests.PurchaseRequest;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "purchases")
@Getter
@Setter
public class Purchase extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private LocalTime startTime;
    private LocalTime endTime;
    private int regularPrice;
    private int discountPrice;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String purchaser;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private int payment;

    @Column(nullable = false, length = 10)
    private String payMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus reservationStatus;

    @Column(length = 500)
    private String cancelReason;

    private List<String> cancelImgUrls = new ArrayList<>();

    private boolean isRefunded;

    public Purchase(User user, Product product, PurchaseRequest req) {
        setName(req.getName());
        setPurchaser(req.getPurchaser());
        setPayMethod(req.getPayMethod());
        setPayment(req.getPayment());
        setStartTime(req.getStartTime());
        setEndTime(req.getEndTime());
        setDayOfWeek(req.getDayOfWeek());
        setRegularPrice(req.getRegularPrice());
        setDiscountPrice(req.getDiscountPrice());
    }

}
