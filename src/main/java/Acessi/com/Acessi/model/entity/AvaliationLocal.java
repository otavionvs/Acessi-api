package Acessi.com.Acessi.model.entity;


import Acessi.com.Acessi.model.enums.AvaliationLocalType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Entity
@Table(name = "AvaliationLocal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliationLocal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idLocalAvaliation;

    @Column(nullable = false, length = 200)
    private String name;

    @Column
    private Float avaliationRating;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String imageAvaliationLocal;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private AvaliationLocalType typeLocalAvaliation;
}
