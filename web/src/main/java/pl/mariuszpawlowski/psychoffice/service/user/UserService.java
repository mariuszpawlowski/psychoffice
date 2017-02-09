package pl.mariuszpawlowski.psychoffice.service.user;

import org.springframework.data.domain.Page;
import pl.mariuszpawlowski.psychoffice.domain.Role;
import pl.mariuszpawlowski.psychoffice.domain.jpa.User;

/**
 * Created by mario on 23/08/15.
 */
public interface UserService {

    User getUserById(long id);

    User getUserByEmail(String email);

    Iterable<User> getAllUsers();

    Page<User> getAllUsersWithRole(Role role);

    User save(User user);

    void delete(User user);
}