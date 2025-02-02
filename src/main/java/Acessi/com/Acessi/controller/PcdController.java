package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.dto.*;
import Acessi.com.Acessi.model.entity.Address;
import Acessi.com.Acessi.model.entity.PCD;
import Acessi.com.Acessi.model.enums.DeficiencyType;
import Acessi.com.Acessi.model.enums.DisabilityType;
import Acessi.com.Acessi.model.enums.EducationLevel;
import Acessi.com.Acessi.model.enums.Gender;
import Acessi.com.Acessi.dto.PcdDTO;
import Acessi.com.Acessi.model.entity.*;
import Acessi.com.Acessi.model.service.PcdService;
import Acessi.com.Acessi.model.service.UserService;
import Acessi.com.Acessi.security.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
                new TokenUtils().getUserEmailByRequest(httpServletRequest)).orElse(null));

        if (pcdDTO.getAddressPCD() != null) {
            Address addressPCD = new Address();
            BeanUtils.copyProperties(pcdDTO.getAddressPCD(), addressPCD);
            pcd.setAddressPCD(addressPCD);
        }

        if (pcdDTO.getAuxiliarPCD() != null) {
            AuxiliarPcd auxiliarPcd = new AuxiliarPcd();
            BeanUtils.copyProperties(pcdDTO.getAuxiliarPCD(), auxiliarPcd);

            if (pcdDTO.getAuxiliarPCD().getAddressAuxiliar() != null) {
                Address addressAuxiliar = new Address();
                BeanUtils.copyProperties(pcdDTO.getAuxiliarPCD().getAddressAuxiliar(), addressAuxiliar);
                auxiliarPcd.setAddressAuxiliar(addressAuxiliar);
            }

            pcd.setAuxiliarPCD(auxiliarPcd);
        }


        InformationDeficiency informationDeficiency = new InformationDeficiency();
        BeanUtils.copyProperties(pcdDTO.getInformationDeficiency(), informationDeficiency);
        pcd.setInformationDeficiency(informationDeficiency);

        return ResponseEntity.status(HttpStatus.OK).body(pcdService.save(pcd));
    }

    @GetMapping("/type")
    public ResponseEntity<List<DisabilityTypeCountDTO>> findDisabilityTypeCount() {
        List<DisabilityTypeCountDTO> disabilityTypeCountDTOS = new ArrayList<>();
        for (Map<String, Long> deficiency : pcdService.countByDeficiencyType()) {
            DisabilityTypeCountDTO disabilityTypeCountDTO = new DisabilityTypeCountDTO(
                    deficiency.get("disabilityTypeCount"),
                    DeficiencyType.valueOf(deficiency.get("disabilityTypeName") + "").getLabel()
            );
            disabilityTypeCountDTOS.add(disabilityTypeCountDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(disabilityTypeCountDTOS);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.status(HttpStatus.OK).body(pcdService.count());
    }

    @GetMapping("/education")
    public ResponseEntity<List<EducationLevelCountDTO>> findEducationCount() {
        List<EducationLevelCountDTO> educationLevelCountDTOS = new ArrayList<>();

        for (EducationLevel education : EducationLevel.values()) {
            educationLevelCountDTOS.add(new EducationLevelCountDTO(
                    pcdService.countByEducationLevelPCD(education),
                    education.getEducationLevel()
            ));
        }

        return ResponseEntity.status(HttpStatus.OK).body(educationLevelCountDTOS);
    }

    @GetMapping("/gender")
    public ResponseEntity<List<GenderCountDTO>> findGenderCount() {
        List<GenderCountDTO> genderCountDTOS = new ArrayList<>();

        for (Gender gender : Gender.values()) {
            genderCountDTOS.add(new GenderCountDTO(
                    pcdService.countByGenderPCD(gender),
                    gender.getGender()
            ));
        }

        return ResponseEntity.status(HttpStatus.OK).body(genderCountDTOS);
    }

    @GetMapping("/neighborhood")
    public ResponseEntity<List<Map<String, Long>>> countByNeighborhood() {
        return ResponseEntity.status(HttpStatus.OK).body(pcdService.countByNeighborhood());
    }

    @GetMapping("/pyramid")
    public ResponseEntity<List<PyramidDTO>> countByAgeAndGender() {
        List<PyramidDTO> pyramidDTOS = new ArrayList<>();
        for(Object[] ageRange : pcdService.countByAgeAndGender()) {
            PyramidDTO pyramidDTO = new PyramidDTO();
            pyramidDTO.setAgeRangeCount((Long) ageRange[2]);
            pyramidDTO.setGenderPCD((String) ageRange[1].toString());
            System.out.println(pyramidDTO.getGenderPCD());
            pyramidDTO.setAgeRange((String) ageRange[0]);

            pyramidDTOS.add(pyramidDTO);
        }

        return ResponseEntity.status(HttpStatus.OK).body(pyramidDTOS);
    }
}
