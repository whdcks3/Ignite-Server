package ignite.api.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import ignite.api.config.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product extends BaseEntity {

}
