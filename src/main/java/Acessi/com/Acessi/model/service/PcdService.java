package Acessi.com.Acessi.model.service;

import Acessi.com.Acessi.dto.DisabilityTypeCountDTO;
import Acessi.com.Acessi.model.entity.PCD;
import Acessi.com.Acessi.model.enums.DisabilityType;
import Acessi.com.Acessi.model.enums.EducationLevel;
import Acessi.com.Acessi.model.enums.Gender;
import Acessi.com.Acessi.repository.PcdRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PcdService {
    private PcdRepository pcdRepository;

    public PCD save(PCD entity) {
        return pcdRepository.save(entity);
    }

    public Optional<PCD> findById(Integer integer) {
        return pcdRepository.findById(integer);
    }

    public List<PCD> findAll() {
        return pcdRepository.findAll();
    }

    public Long countByDisabilityTypePCD(DisabilityType disabilityType) {
        return pcdRepository.countByDisabilityTypePCD(disabilityType);
    }

    public long count() {
        return pcdRepository.count();
    }

    public Long countByEducationLevelPCD(EducationLevel educationLevel) {
        return pcdRepository.countByEducationLevelPCD(educationLevel);
    }

    public Long countByGenderPCD(Gender gender) {
        return pcdRepository.countByGenderPCD(gender);
    }

    public List<Map<String, Long>> countByNeighborhood() {
        return pcdRepository.countByNeighborhood();
    }

    public List<Object[]> countByAgeAndGender() {
        return pcdRepository.countByAgeAndGender();
    }
}
