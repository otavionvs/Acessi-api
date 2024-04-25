package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.dto.AvaliationLocalDTO;
import Acessi.com.Acessi.dto.CompanyDTO;
import Acessi.com.Acessi.model.entity.AvaliationLocal;
import Acessi.com.Acessi.model.entity.Company;
import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.model.enums.AccessLevel;
import Acessi.com.Acessi.model.service.AvaliationLocalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/avaliation")
public class AvaliationLocalController {

    private AvaliationLocalService avaliationService;

    @GetMapping
    public ResponseEntity<List<AvaliationLocal>> findAll() {
        return ResponseEntity.ok(avaliationService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<AvaliationLocal> findById(@PathVariable Integer id){
        Optional<AvaliationLocal> avaliationLocal = avaliationService.findById(id);

        if (avaliationLocal.isPresent()) {
            return ResponseEntity.ok(avaliationLocal.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AvaliationLocalDTO avaliationDTO) {
        AvaliationLocal avaliationLocal = new AvaliationLocal();
        BeanUtils.copyProperties(avaliationDTO, avaliationLocal);
        return ResponseEntity.status(HttpStatus.OK).body(avaliationService.save(avaliationLocal));
    }



}
