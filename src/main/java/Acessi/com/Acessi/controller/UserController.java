package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.dto.UserDTO;
import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.model.enums.AccessLevel;
import Acessi.com.Acessi.model.service.UserService;
import Acessi.com.Acessi.security.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        Optional<User> user = userService.findById(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setAccessLevelUser(AccessLevel.User);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPasswordUser(encoder.encode(user.getPasswordUser()));
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    }

    @GetMapping("/isAdmin")
    public  ResponseEntity<Boolean> isAdmin(HttpServletRequest httpServletRequest) {
        User user = userService.findByEmailUser(
                new TokenUtils().getUserEmailByRequest(httpServletRequest)).orElse(null);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user.getAccessLevelUser() == AccessLevel.Admin);
        }
        return ResponseEntity.status(HttpStatus.OK).body(false);
    }

}
