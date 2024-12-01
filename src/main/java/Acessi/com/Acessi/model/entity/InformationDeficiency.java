package Acessi.com.Acessi.model.entity;

import Acessi.com.Acessi.model.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "informationDeficiency")
public class InformationDeficiency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean deficiencyAcquired;

    @Enumerated(value = EnumType.STRING)
    private DeficiencyType deficiency;

    @Enumerated(value = EnumType.STRING)
    private FormTypeDeficiency formTypeDeficiency;

    private Boolean accessSchool;

    private String schoolName;

    @Enumerated(value = EnumType.STRING)
    private SchoolType schoolType;

    private Boolean regularEducationClass;

    private String specializedEducationalService;

    private String yearCicle;

    private Integer frequencyDaysWeek;

    private String travelTime;

    private Boolean needsCompany;

    private Boolean lackOfAccessibilityWay;

    private String barriersWay;

    private Boolean affordableTransportations;

    @Enumerated(value = EnumType.STRING)
    private TypeTransportation typeTransportation;

    private Boolean hasSupportProfessional;

    private Boolean needsSupportExtraActivities;

    private Boolean physicalBarriersSchool;

    private Boolean playWithColleagues;

    private Boolean hasCaregiver;

    @Enumerated(value = EnumType.STRING)
    private PrimaryCaregiver primaryCaregiver;

    @Enumerated(value = EnumType.STRING)
    private BenefitsRecived benefitsRecived;

    private Boolean freePublicTransport;

    private Boolean accessiblePublicTransport;

    @Enumerated(value = EnumType.STRING)
    private AreaResidence areaResidence;

    @Enumerated(value = EnumType.STRING)
    private HousingConditions housingConditions;

    @OneToOne
    @JoinColumn(name = "idPCD", nullable = false)
    private PCD pcd;
}
