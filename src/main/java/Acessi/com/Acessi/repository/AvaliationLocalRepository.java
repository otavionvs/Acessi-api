package Acessi.com.Acessi.repository;

import Acessi.com.Acessi.model.entity.AvaliationLocal;
import Acessi.com.Acessi.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliationLocalRepository extends JpaRepository<AvaliationLocal, Integer>
{
    List<AvaliationLocal> findByName(String name);
    List<AvaliationLocal> findByNameContaining(String name);
    @Modifying
    @Query("UPDATE AvaliationLocal a SET a.avaliationRating = :avaliationRating WHERE a.idLocalAvaliation = :id")
    void updateAvaliationRating(@Param("id") Integer id, @Param("avaliationRating") Float avaliationRating);
}
