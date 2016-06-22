package pl.mariuszpawlowski.psychoffice.service.user;

import pl.mariuszpawlowski.psychoffice.domain.Role;
import pl.mariuszpawlowski.psychoffice.domain.jpa.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by mario on 23/08/15.
 */
public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Iterable<User> getAllUsers();

    List<User> getAllUsersWithRole(Role role);

    User create(User form);

}