package ignite.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ignite.api.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Long, Review> {

}
