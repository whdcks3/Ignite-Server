package ignite.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;

@Entity
@Table(name = "company_images")
@AllArgsConstructor
public class CompanyImage {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pid")
    private Company company;

    private String imageUrl;

    @Column(nullable = false)
    private boolean isMain;

}
