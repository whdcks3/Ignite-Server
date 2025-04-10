package ignite.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import ignite.api.config.BaseEntity;
import ignite.api.models.enums.Category;
import ignite.api.models.requests.CompanyImageRequest;
import ignite.api.models.requests.CompanyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String phone;

    private List<Category> categories = new ArrayList<>();

    private List<CompanyImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String bankAccount;

    @Column(columnDefinition = "TEXT")
    private String content;

    private double latitude;
    private double longitude;

    private String address;

    private int totalRating;
    private int reservedCount;
    private double avgRating;

    public Company(User user, CompanyRequest req) {
        setName(req.getName());
        setBankAccount(req.getBankAccount());
        setBankName(req.getBankName());
        setPhone(req.getPhone());
        for (CompanyImageRequest imgDto : req.getImages()) {
            CompanyImage img = new CompanyImage(this, imgDto.getImageUrl(), imgDto.isMain());
            images.add(img);
        }
        setCategories(req.getCategories());
        setContent(req.getContent());
    }
}
