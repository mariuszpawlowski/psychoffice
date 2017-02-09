package pl.mariuszpawlowski.psychoffice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.mariuszpawlowski.psychoffice.domain.jpa.User;

public interface UserRepository extends Repository<User, Long> {

    Page<User> findAll(Pageable pageable);

    User findById(Long id);

    @Query("SELECT u FROM User u WHERE LOWER(u.userDetails.name) = LOWER(:name)")
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.role = :role")
    Page<User> findAllByRole(String role, Pageable pageable);

    User save(User user);

    void delete(User user);
}

