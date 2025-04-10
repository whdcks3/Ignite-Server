package ignite.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import ignite.api.config.BaseEntity;
import ignite.api.models.community.Community;
import ignite.api.models.enums.Category;
import ignite.api.models.enums.SocialType;
import ignite.api.models.requests.RegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false, length = 30)
    private String name;

    @Email
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column
    private String profileImgUrl;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Community> communities = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private List<Category> favoriteCategories = new ArrayList<>();

    public User(RegisterRequest req) {
        setName(req.getName());
        setEmail(req.getEmail());
        setPhone(req.getPhone());
        setSocialType(req.getSocialType());
        setProfileImgUrl(req.getImage());
        setFavoriteCategories(req.getCategories());
    }
}
