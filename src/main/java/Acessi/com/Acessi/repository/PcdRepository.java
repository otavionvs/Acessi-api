package Acessi.com.Acessi.repository;

import Acessi.com.Acessi.model.entity.PCD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcdRepository extends JpaRepository<PCD, Integer> {

}
