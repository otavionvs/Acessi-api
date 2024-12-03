package Acessi.com.Acessi.repository;

import Acessi.com.Acessi.model.entity.AvaliationLocal;
import Acessi.com.Acessi.model.entity.AvaliationLocalItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliationLocalItemRepository extends JpaRepository<AvaliationLocalItem, Integer> {
    List<AvaliationLocalItem> findByAvaliationLocal_IdLocalAvaliation(Integer idLocalAvaliation);
}
