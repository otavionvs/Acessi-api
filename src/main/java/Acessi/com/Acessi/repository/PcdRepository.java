package Acessi.com.Acessi.repository;

import Acessi.com.Acessi.dto.DisabilityTypeCountDTO;
import Acessi.com.Acessi.model.entity.PCD;
import Acessi.com.Acessi.model.enums.DeficiencyType;
import Acessi.com.Acessi.model.enums.DisabilityType;
import Acessi.com.Acessi.model.enums.EducationLevel;
import Acessi.com.Acessi.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PcdRepository extends JpaRepository<PCD, Integer> {

//    Long countByDeficiencyType(DeficiencyType deficiencyType);
    Long countByEducationLevelPCD(EducationLevel educationLevel);
    Long countByGenderPCD(Gender gender);

    @Query("SELECT a.deficiency as disabilityTypeName, COUNT(p.idPCD) as disabilityTypeCount FROM PCD p JOIN p.informationDeficiency a GROUP BY a.deficiency")
    List<Map<String, Long>>  countByDeficiencyType();

    @Query("SELECT a.neighborhoodAddress as neighborhoodName, COUNT(p.idPCD) as neighborhoodCount FROM PCD p JOIN p.addressPCD a GROUP BY a.neighborhoodAddress")
    List<Map<String, Long>> countByNeighborhood();

    @Query("SELECT " +
            "CASE " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) BETWEEN 0 AND 10 THEN '0-10' " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) BETWEEN 11 AND 20 THEN '11-20' " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) BETWEEN 21 AND 30 THEN '21-30' " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) BETWEEN 31 AND 40 THEN '31-40' " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) BETWEEN 41 AND 50 THEN '41-50' " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) BETWEEN 51 AND 60 THEN '51-60' " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) BETWEEN 61 AND 70 THEN '61-70' " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) BETWEEN 71 AND 80 THEN '71-80' " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) BETWEEN 81 AND 90 THEN '81-90' " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) BETWEEN 91 AND 100 THEN '91-100' " +
            "    WHEN YEAR(CURDATE()) - YEAR(p.birthDatePCD) > 100 THEN '100+' " +
            "END AS ageRange, " +
            "p.genderPCD, " +
            "COUNT(*) AS ageRangeCount " +
            "FROM PCD p " +
            "GROUP BY ageRange, p.genderPCD " +
            "ORDER BY p.genderPCD")
    List<Object[]> countByAgeAndGender();
}
