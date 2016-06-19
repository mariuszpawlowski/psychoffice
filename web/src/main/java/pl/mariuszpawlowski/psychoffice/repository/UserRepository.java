package pl.mariuszpawlowski.psychoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.mariuszpawlowski.psychoffice.domain.Role;
import pl.mariuszpawlowski.psychoffice.domain.jpa.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByEmail(String email);

    @Query("SELECT u FROM User u WHERE LOWER(u.userDetails.name) = LOWER(:name)")
    public User find(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.role = :role")
    public List<User> getAllWithRole(@Param("role") Role role);
}

