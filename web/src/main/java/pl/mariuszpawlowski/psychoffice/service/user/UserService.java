package pl.mariuszpawlowski.psychoffice.service.user;


import pl.mariuszpawlowski.psychoffice.domain.jpa.User;
import pl.mariuszpawlowski.psychoffice.domain.form.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by mario on 23/08/15.
 */
public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Iterable<User> getAllUsers();

    User create(UserCreateForm form);

}