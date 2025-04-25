package ignite.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ignite.api.models.ProductSchedule;

@Repository
public interface ProductScheduleRepository extends JpaRepository<ProductSchedule, Long> {

}
