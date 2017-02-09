package pl.mariuszpawlowski.psychoffice.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pl.mariuszpawlowski.psychoffice.domain.Role;
import pl.mariuszpawlowski.psychoffice.domain.jpa.User;
import pl.mariuszpawlowski.psychoffice.repository.UserRepository;

/**
 * Created by mario on 23/08/15.
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(long id) {
        LOGGER.debug("Getting user={}", id);
        return userRepository.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userRepository.findByEmail(email);
    }

    @Override
    public Iterable<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll(null);
    }

    @Override
    public Page<User> getAllUsersWithRole(Role role) {
        return userRepository.findAllByRole(role, null);
    }

    @Override
    public User save(User user) {
          return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
