package Acessi.com.Acessi.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InformationDeficiencyDTO {
    private Boolean deficiencyAcquired;
    private String deficiency;
    private String formTypeDeficiency;
    private Boolean accessSchool;
    private String schoolName;
    private String schoolType;
    private Boolean regularEducationClass;
    private String specializedEducationalService;
    private String yearCicle;
    private Integer frequencyDaysWeek;
    private String travelTime;
    private Boolean needsCompany;
    private Boolean lackOfAccessibilityWay;
    private String barriersWay;
    private Boolean affordableTransportations;
    private String typeTransportation;
    private Boolean hasSupportProfessional;
    private Boolean needsSupportExtraActivities;
    private Boolean physicalBarriersSchool;
    private Boolean playWithColleagues;
    private Boolean hasCaregiver;
    private String primaryCaregiver;
    private List<String> benefitsRecived;
    private Boolean freePublicTransport;
    private Boolean accessiblePublicTransport;
    private String areaResidence;
    private String housingConditions;
}
