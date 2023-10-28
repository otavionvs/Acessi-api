package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.dto.UserDTO;
import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.model.enums.AccessLevel;
import Acessi.com.Acessi.model.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public Optional<User> findById(Integer integer) {
        return userService.findById(integer);
    }

    public ResponseEntity<Object> save(@RequestBody @Valid UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setAccessLevelUser(AccessLevel.User);
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    }


}
