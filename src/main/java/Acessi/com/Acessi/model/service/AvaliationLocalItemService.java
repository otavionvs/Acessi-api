package Acessi.com.Acessi.model.service;


import Acessi.com.Acessi.model.entity.AvaliationLocal;
import Acessi.com.Acessi.model.entity.AvaliationLocalItem;
import Acessi.com.Acessi.repository.AvaliationLocalItemRepository;
import Acessi.com.Acessi.repository.AvaliationLocalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AvaliationLocalItemService {
    private AvaliationLocalItemRepository avaliationLocalItemRepository;

    public AvaliationLocalItem save(AvaliationLocalItem entity) {
        return avaliationLocalItemRepository.save(entity);
    }

    public List<AvaliationLocalItem> findAll() {
        return avaliationLocalItemRepository.findAll();
    }

    public Optional<AvaliationLocalItem> findById(Integer integer) {
        return avaliationLocalItemRepository.findById(integer);
    }

}
