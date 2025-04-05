package ignite.api.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ignite.api.config.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "purchase")
@Getter
@Setter
public class Purchase extends BaseEntity {

    @ManyToOne
    private User user;

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

}
