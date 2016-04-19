package pl.mariuszpawlowski.psychoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mariuszpawlowski.psychoffice.domain.jpa.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
}