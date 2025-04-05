package ignite.api.models;

import javax.persistence.Column;
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

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private int regularPrice;

    private int discountPrice;

    @Column(nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "company_pid")
    private Company company;

    private String kakaoAdress;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String address;

}
