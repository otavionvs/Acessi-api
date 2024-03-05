package Acessi.com.Acessi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idCompany;
    @Column(nullable = false, length = 14)
    private String cnpjCompany;
    @Column(nullable = false)
    private String companyName;
    @Column
    private String siteCompany;
    @Column(nullable = false)
    private String areaCompany;
    @Column(nullable = false, length = 11)
    private String telephoneCompany;
    @Column(nullable = false)
    private String emailCompany;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User userCompany;
}
