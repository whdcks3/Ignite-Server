package ignite.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ignite.api.models.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
