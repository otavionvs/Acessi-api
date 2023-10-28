package Acessi.com.Acessi.model.service;

import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User save(User entity) {
        return userRepository.save(entity);
    }

    public Optional<User> findById(Integer integer) {
        return userRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return userRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        userRepository.deleteById(integer);
    }
}
