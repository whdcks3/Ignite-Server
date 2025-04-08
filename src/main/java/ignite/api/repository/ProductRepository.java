package ignite.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ignite.api.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Long, Product> {

}
