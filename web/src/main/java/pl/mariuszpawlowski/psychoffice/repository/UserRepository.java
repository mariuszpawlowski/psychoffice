package pl.mariuszpawlowski.psychoffice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mariuszpawlowski.psychoffice.domain.jpa.User;

public interface UserRepository extends CrudRepository<User, Long> {
  /*  Optional<User> findOneByEmail(String email);

    @Query("SELECT u FROM User u WHERE LOWER(u.userDetails.name) = LOWER(:name)")
    public User find(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.role = :role")
    public List<User> getAllWithRole(@Param("role") Role role); */
}

