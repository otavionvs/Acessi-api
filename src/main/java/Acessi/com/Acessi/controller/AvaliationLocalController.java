package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.dto.AvaliationLocalDTO;
import Acessi.com.Acessi.dto.CompanyDTO;
import Acessi.com.Acessi.model.entity.AvaliationLocal;
import Acessi.com.Acessi.model.entity.AvaliationLocalItem;
import Acessi.com.Acessi.model.entity.Company;
import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.model.enums.AccessLevel;
import Acessi.com.Acessi.model.service.AvaliationLocalItemService;
import Acessi.com.Acessi.model.service.AvaliationLocalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/avaliation")
public class AvaliationLocalController {

    private AvaliationLocalService avaliationService;

    private AvaliationLocalItemService avaliationItemService;

    @GetMapping("/search-all-avaliation")
    public ResponseEntity<List<AvaliationLocal>> findAll()
    {
        return ResponseEntity.ok(avaliationService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        Optional<AvaliationLocal> avaliationLocal = avaliationService.findById(id);
        if(avaliationLocal.isPresent()){
            avaliationService.deleteById(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliationLocal> findById(@PathVariable Integer id){
        Optional<AvaliationLocal> avaliationLocal = avaliationService.findById(id);

        if (avaliationLocal.isPresent()) {
            return ResponseEntity.ok(avaliationLocal.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search-avaliation")
    public ResponseEntity<List<AvaliationLocal>> findByName(@RequestParam String name) {
        List<AvaliationLocal> listAvaliationLocal = avaliationService.findByNameContaining(name);

        if (!listAvaliationLocal.isEmpty()) {
            return ResponseEntity.ok(listAvaliationLocal);
        }
        return  ResponseEntity.ok(new ArrayList<AvaliationLocal>());
    }

    @GetMapping("/get-avaliation-itens")
    public ResponseEntity<List<AvaliationLocalItem>> findAvaliationComments(@RequestParam Integer idAvaliation) {
        List<AvaliationLocalItem> avaliationItens = avaliationItemService.findByIdLocalAvaliation(idAvaliation);

        if (!avaliationItens.isEmpty()) {
            return ResponseEntity.ok(avaliationItens);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody AvaliationLocalDTO avaliationDTO) {
        AvaliationLocal avaliationLocal = new AvaliationLocal();
        BeanUtils.copyProperties(avaliationDTO, avaliationLocal);

        return ResponseEntity.status(HttpStatus.OK).body(avaliationService.save(avaliationLocal));
    }


    @PostMapping("/register-avaliation-item")
    public ResponseEntity<Object> registerAvaliationItem(@RequestBody AvaliationLocalItem avaliationItemDTO) {
        AvaliationLocalItem avaliationItemLocal = new AvaliationLocalItem();
        BeanUtils.copyProperties(avaliationItemDTO, avaliationItemLocal);

        return ResponseEntity.status(HttpStatus.OK).body(avaliationItemService.save(avaliationItemLocal));
    }



}
