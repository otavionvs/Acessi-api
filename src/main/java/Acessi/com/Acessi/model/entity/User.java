package Acessi.com.Acessi.model.entity;

import Acessi.com.Acessi.model.enums.AccessLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idUser;
    @Column(nullable = false, length = 150)
    private String nameUser;
    @Column(nullable = false, unique = true)
    private String emailUser;
    @Column(nullable = false)
    @JsonIgnore
    private String passwordUser;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AccessLevel accessLevelUser;
}
