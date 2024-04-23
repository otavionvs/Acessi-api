package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.dto.CompanyDTO;
import Acessi.com.Acessi.model.entity.Company;
import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.model.enums.AccessLevel;
import Acessi.com.Acessi.model.service.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable Integer id) {
        Optional<Company> company = companyService.findById(id);

        if (company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CompanyDTO companyDTO) {
        System.out.println("Entrou");
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO, company);

        User user = new User();
        BeanUtils.copyProperties(companyDTO.getUserCompany(), user);
        user.setAccessLevelUser(AccessLevel.Company);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPasswordUser(encoder.encode(user.getPasswordUser()));

        company.setUserCompany(user);
        return ResponseEntity.status(HttpStatus.OK).body(companyService.save(company));
    }
}
