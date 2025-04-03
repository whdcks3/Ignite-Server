package ignite.api.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import ignite.api.config.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "purchase")
@Getter
@Setter
public class Purchase extends BaseEntity {

    private String name;

    private String purchaser;
    private String phone;
    private int payment;
    private String payMethod;

}
