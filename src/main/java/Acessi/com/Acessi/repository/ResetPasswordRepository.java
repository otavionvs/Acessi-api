package Acessi.com.Acessi.repository;

import Acessi.com.Acessi.model.entity.ResetPasswordToken;
import Acessi.com.Acessi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ResetPasswordRepository extends JpaRepository<ResetPasswordToken, Integer> {
    Optional<ResetPasswordToken> findResetByEmail(String email);

    @Query("SELECT r FROM ResetPasswordToken r WHERE r.email = :email ORDER BY r.dataExpiracao DESC")
    List<ResetPasswordToken> findAllByEmailOrderByDataExpiracaoDesc(@Param("email") String email);

}
