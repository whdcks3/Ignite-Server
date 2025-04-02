package ignite.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import ignite.api.config.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "community")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Community extends BaseEntity {

    private List<String> category = new ArrayList<>();

    private String title;

    private String content;

    private List<String> image = new ArrayList<>();
}
