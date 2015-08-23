package pl.psychoffice.service.user;

import pl.psychoffice.domain.User;
import pl.psychoffice.domain.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by mario on 23/08/15.
 */
public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}