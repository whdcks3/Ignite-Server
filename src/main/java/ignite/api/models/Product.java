package ignite.api.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ignite.api.config.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    private String name;
    private int regularPrice;
    private int discountPrice;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "company_pid")
    private Company company;

    private String kakaoAdress;
    private String content;
    private String address;

}
