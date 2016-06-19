package pl.mariuszpawlowski.psychoffice.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mariuszpawlowski.psychoffice.domain.Role;
import pl.mariuszpawlowski.psychoffice.domain.form.UserCreateForm;
import pl.mariuszpawlowski.psychoffice.domain.jpa.User;
import pl.mariuszpawlowski.psychoffice.domain.jpa.UserDetails;
import pl.mariuszpawlowski.psychoffice.repository.UserRepository;

import java.util.Optional;

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
    public Optional<User> getUserById(long id) {
        LOGGER.debug("Getting user={}", id);
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Iterable<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll();
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        //user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(Role.USER);
        user.setUserDetails(getUserDetails(form));
        return userRepository.save(user);
    }

    private UserDetails getUserDetails(UserCreateForm form) {
        UserDetails userDetails = new UserDetails();
        userDetails.setCity(form.getCity());
        userDetails.setName(form.getName());
        userDetails.setSurname(form.getSurname());
        userDetails.setPhone(form.getPhone());
        return userDetails;
    }

}
