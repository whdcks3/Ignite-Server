package ignite.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ignite.api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
