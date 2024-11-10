package Acessi.com.Acessi.model.entity;


import Acessi.com.Acessi.model.enums.AvaliationLocalType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "AvaliationLocalItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliationLocalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idLocalItemAvaliation;

    @ManyToOne
    @JoinColumn(name = "idLocalAvaliation", referencedColumnName = "idLocalAvaliation", nullable = false)
    private AvaliationLocal avaliationLocal;

    @Column(nullable = false, length = 500)
    private String avaliationGivenByUser;

    @Column
    private Float avaliationRating;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime dateAvaliation;
}
