package Acessi.com.Acessi.repository;

import Acessi.com.Acessi.model.entity.AvaliationLocal;
import Acessi.com.Acessi.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliationLocalRepository extends JpaRepository<AvaliationLocal, Integer>
{
    // Método de consulta baseado no nome da propriedade
    List<AvaliationLocal> findByName(String name);

}
