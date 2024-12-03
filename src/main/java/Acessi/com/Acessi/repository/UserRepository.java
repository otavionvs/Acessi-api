package Acessi.com.Acessi.repository;

import Acessi.com.Acessi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailUser(String email);
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.passwordUser = :passwordUser WHERE u.idUser = :id")
    void updatePasswordUser(@Param("id") Integer id, @Param("passwordUser") String password);
}
