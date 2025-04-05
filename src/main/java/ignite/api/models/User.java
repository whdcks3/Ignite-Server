package ignite.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import ignite.api.config.BaseEntity;
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
    private String image;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Community> communities = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private List<String> favoriteCategory = new ArrayList<>();

    public void update() {
    }
}
