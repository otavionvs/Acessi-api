package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.model.enums.DisabilityType;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/disability-type")
public class DisabilityTypeController {

    @GetMapping
    public Map<String, String> findAll() {
        Map<String, String> disabilityTypes = new HashMap<>();
        for (DisabilityType type : DisabilityType.values()) {
            disabilityTypes.put(type.name(), type.getDescricao());
        }
        return disabilityTypes;
    }
}
