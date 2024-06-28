package Acessi.com.Acessi.model.service;


import Acessi.com.Acessi.model.entity.AvaliationLocal;
import Acessi.com.Acessi.model.entity.Company;
import Acessi.com.Acessi.repository.AvaliationLocalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AvaliationLocalService {
    private AvaliationLocalRepository avaliationLocalRepository;

    public AvaliationLocal save(AvaliationLocal entity) {
        return avaliationLocalRepository.save(entity);
    }

    public List<AvaliationLocal> findAll() {
        return avaliationLocalRepository.findAll();
    }

    public Optional<AvaliationLocal> findById(Integer integer) {
        return avaliationLocalRepository.findById(integer);
    }

    public void deleteById(Integer integer) {
        avaliationLocalRepository.deleteById(integer);
    }
}
