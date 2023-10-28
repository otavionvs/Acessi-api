package Acessi.com.Acessi.security.service;

import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.repository.UserRepository;
import Acessi.com.Acessi.security.users.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaService implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(
            String username) throws UsernameNotFoundException {
        Optional<User> userOptional;
        userOptional = userRepository.findByEmailUser(username);

        if (userOptional.isPresent()) {
            return new UserJpa(userOptional.get());
        }

        throw new UsernameNotFoundException("Usuário não encontrado!");
    }
}
