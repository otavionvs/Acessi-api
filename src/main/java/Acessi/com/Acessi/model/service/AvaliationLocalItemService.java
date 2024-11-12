package Acessi.com.Acessi.model.service;


import Acessi.com.Acessi.model.entity.AvaliationLocal;
import Acessi.com.Acessi.model.entity.AvaliationLocalItem;
import Acessi.com.Acessi.repository.AvaliationLocalItemRepository;
import Acessi.com.Acessi.repository.AvaliationLocalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AvaliationLocalItemService {
    private AvaliationLocalItemRepository avaliationLocalItemRepository;
    private AvaliationLocalRepository avaliationLocalRepository;

    @Transactional
    public AvaliationLocalItem save(AvaliationLocalItem entity) {
        if (Optional.ofNullable(entity.getAvaliationLocal()).isPresent()) {
            Integer idLocalAvaliation = entity.getAvaliationLocal().getIdLocalAvaliation();

            List<AvaliationLocalItem> itensAvaliations =
                    avaliationLocalItemRepository.findByAvaliationLocal_IdLocalAvaliation(idLocalAvaliation);

            itensAvaliations.add(entity);

            double averageRating = itensAvaliations.stream()
                    .mapToDouble(AvaliationLocalItem::getAvaliationRating)
                    .average()
                    .orElse(0.0);

            avaliationLocalRepository.updateAvaliationRating(
                    idLocalAvaliation,
                    (float) averageRating
            );
        }

        // Salvar a entidade e retornar
        return avaliationLocalItemRepository.save(entity);
    }


    public List<AvaliationLocalItem> findAll() {
        return avaliationLocalItemRepository.findAll();
    }

    public Optional<AvaliationLocalItem> findById(Integer integer) {
        return avaliationLocalItemRepository.findById(integer);
    }
    public List<AvaliationLocalItem> findByIdLocalAvaliation(Integer idAvaliation) {
        return avaliationLocalItemRepository.findByAvaliationLocal_IdLocalAvaliation(idAvaliation);
    }

}
