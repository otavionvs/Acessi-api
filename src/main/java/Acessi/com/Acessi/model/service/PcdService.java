package Acessi.com.Acessi.model.service;

import Acessi.com.Acessi.model.entity.PCD;
import Acessi.com.Acessi.repository.PcdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
