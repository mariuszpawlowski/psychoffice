package pl.psychoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.psychoffice.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
}
