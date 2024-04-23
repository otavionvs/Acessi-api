package Acessi.com.Acessi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idAddress;
    @Column(nullable = false)
    private String cityAddress;
    @Column(nullable = false)
    private String streetAddress;
    @Column(nullable = false)
    private String neighborhoodAddress;
    @Column(nullable = false)
    private Integer numberAddress;
    @Column
    private String complementAddress;
    @Column(nullable = false, length = 10)
    private String cepAddress;
}
