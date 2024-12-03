package Acessi.com.Acessi.model.entity;

import Acessi.com.Acessi.model.enums.AccessLevel;
import Acessi.com.Acessi.model.enums.DisabilityType;
import Acessi.com.Acessi.model.enums.EducationLevel;
import Acessi.com.Acessi.model.enums.Gender;
import Acessi.com.Acessi.model.enums.Race;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "pcd")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PCD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idPCD;
    @Column(nullable = false, length = 150)
    private String namePCD;
    @Column(nullable = false, length = 11)
    private String cpfPCD;
    @Column(nullable = false)
    private Date birthDatePCD;
    @Column(nullable = false)
    private String telephonePCD;
    @Column(nullable = false)
    private String emailPCD;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender genderPCD;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EducationLevel educationLevelPCD;

    @Enumerated(value = EnumType.STRING)
    private Race race;

    private String bpcNumber;
    private String nit;
    private String susNumber;
    private Boolean hasSons;
    private Boolean neededAssistency;

    @Column(nullable = false)
    private Boolean employee;
    @Column(nullable = false)
    private Boolean publicTransportation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address addressPCD;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_auxiliarPCD")
    private AuxiliarPcd auxiliarPCD;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_informationDeficiency", nullable = false)
    private InformationDeficiency informationDeficiency;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
