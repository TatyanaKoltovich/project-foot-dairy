package by.tms.projectfootdairy.service;

import by.tms.projectfootdairy.entity.Role;
import by.tms.projectfootdairy.entity.User;
import by.tms.projectfootdairy.exception.NotFoundException;
import by.tms.projectfootdairy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void save(User user) {
        user.setPassword(new BCryptPasswordEncoder(11).encode(user.getPassword()));
        user.setRoles(Set.of(Role.ROLE_USER));
        userRepository.save(user);
    }


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public User save(User user) {
//        user.setPassword(new BCryptPasswordEncoder(11).encode(user.getPassword()));
//        user.setRoles(Set.of(Role.ROLE_USER));
//        return userRepository.save(user);
//    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new NotFoundException("User not Found"));

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            return byUsername.get();
        }
        throw new UsernameNotFoundException(username);
    }
}
