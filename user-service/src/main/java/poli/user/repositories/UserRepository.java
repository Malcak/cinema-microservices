package poli.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poli.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
