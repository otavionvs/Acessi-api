package Acessi.com.Acessi.model.service;


import Acessi.com.Acessi.model.entity.AvaliationLocal;
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

    public List<AvaliationLocal> findByName(String name)
    {
        return avaliationLocalRepository.findByName(name);
    }

    public List<AvaliationLocal> findByNameContaining(String name)
    {
        return avaliationLocalRepository.findByNameContaining(name);
    }

    public void deleteById(Integer integer) {
        avaliationLocalRepository.deleteById(integer);
    }
}
