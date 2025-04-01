package ignit.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import ignit.api.config.BaseEntity;
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

    @NotBlank
    private String name;

    @Email
    private String email;

    private String phone;

    private List<String> category = new ArrayList<>();

    private List<String> image = new ArrayList<>();

    private String bankName;
    private String bankAccount;

    @Column(columnDefinition = "TEXT")
    private String introduction;
}
