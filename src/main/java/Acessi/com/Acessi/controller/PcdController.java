package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.dto.PcdDTO;
import Acessi.com.Acessi.model.entity.Address;
import Acessi.com.Acessi.model.entity.PCD;
import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.model.enums.AccessLevel;
import Acessi.com.Acessi.model.service.PcdService;
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

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/pcd")
public class PcdController {
    private PcdService pcdService;
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<PCD>> findAll() {
        return ResponseEntity.ok(pcdService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PCD> findById(@PathVariable Integer id) {
        Optional<PCD> pcd = pcdService.findById(id);

        if (pcd.isPresent()) {
            return ResponseEntity.ok(pcd.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PcdDTO pcdDTO,
                                       HttpServletRequest httpServletRequest) {
        PCD pcd = new PCD();
        BeanUtils.copyProperties(pcdDTO, pcd);
        pcd.setUser(userService.findByEmailUser(
                new TokenUtils().getUserEmailByRequest(httpServletRequest)).get());
        Address address = new Address();
        BeanUtils.copyProperties(pcdDTO.getAddressPCD(), address);
        pcd.setAddressPCD(address);
        return ResponseEntity.status(HttpStatus.OK).body(pcdService.save(pcd));
    }
}
