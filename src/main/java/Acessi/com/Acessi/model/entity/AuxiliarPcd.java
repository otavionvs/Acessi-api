package Acessi.com.Acessi.model.entity;

import Acessi.com.Acessi.model.enums.FamilyBond;
import Acessi.com.Acessi.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "auxiliarPcd")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuxiliarPcd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nameAuxiliar;

    @Column(nullable = false, unique = true)
    private String cpfAuxiliar;

    @Column(nullable = false)
    private Date birthDateAuxiliar;

    @Column(nullable = false)
    private String telephoneAuxiliar;

    @Column(nullable = false, unique = true)
    private String emailAuxiliar;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Gender genderAuxiliar;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private FamilyBond familyBond;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAdress", nullable = false)
    private Address addressAuxiliar;
}
