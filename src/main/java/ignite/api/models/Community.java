package ignite.api.models;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "community")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Community extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_pid")
    private User user;

    private List<String> category = new ArrayList<>();

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private List<String> image = new ArrayList<>();
}
