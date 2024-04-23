package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.model.entity.AvaliationLocal;
import Acessi.com.Acessi.model.entity.Company;
import Acessi.com.Acessi.model.service.AvaliationLocalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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





}
