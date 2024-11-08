package Acessi.com.Acessi.model.entity;


import Acessi.com.Acessi.model.enums.AvaliationLocalType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column
    private Integer idLocalAvaliation;

    @Column(nullable = false, length = 500)
    private String avaliationGivenByUser;

    @Column
    private Float avaliationRating;

    @Column(nullable = false, length = 500)
    private String idUser;

}
