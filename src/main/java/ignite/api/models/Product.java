package ignite.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ignite.api.config.BaseEntity;
import ignite.api.models.enums.Category;
import ignite.api.models.enums.ProductType;
import ignite.api.models.requests.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pid")
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductType productType;

    private List<Category> productCategories = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductSchedule> schedules = new ArrayList<>();

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private int regularPrice;

    private int discountPrice;

    @Column(nullable = false)
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String address;

    public Product(Company company, ProductRequest req) {
        setCompany(company);
        setProductType(req.getProductType());
        setProductCategories(req.getCategories());
        setSchedules(schedules); // To Do
        setName(req.getName());
        setRegularPrice(req.getRegularPrice());
        setDiscountPrice(req.getDiscountPrice());
        setContent(req.getContent());

    }

}
