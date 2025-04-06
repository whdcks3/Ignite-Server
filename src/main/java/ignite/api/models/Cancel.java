package ignite.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ignite.api.config.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cancle")
@Getter
@Setter
public class Cancle extends BaseEntity {

    // private List<String> category = new ArrayList<>();

    @Column(columnDefinition = "TEXT")
    private String content;

    private List<String> image = new ArrayList<>();

}
