package Acessi.com.Acessi.model.entity;

import Acessi.com.Acessi.model.enums.AccessLevel;
import Acessi.com.Acessi.model.enums.EducationLevel;
import Acessi.com.Acessi.model.enums.Gender;
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
    @Column(nullable = false, length = 14)
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
    @Column(nullable = false)
    private Boolean employee;
    @Column(nullable = false)
    private Boolean publicTransportation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address addressPCD;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
