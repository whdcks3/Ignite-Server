package ignite.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ignite.api.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
