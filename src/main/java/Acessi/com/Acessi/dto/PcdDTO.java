package Acessi.com.Acessi.dto;

import Acessi.com.Acessi.model.entity.Address;
import Acessi.com.Acessi.model.entity.AuxiliarPcd;
import Acessi.com.Acessi.model.entity.InformationDeficiency;
import Acessi.com.Acessi.model.enums.DisabilityType;
import Acessi.com.Acessi.model.enums.EducationLevel;
import Acessi.com.Acessi.model.enums.Gender;
import Acessi.com.Acessi.model.enums.Race;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

@Getter
public class PcdDTO {
    @NotBlank
    private String namePCD;
    @NotBlank
    private String cpfPCD;
    @NotNull
    private Date birthDatePCD;
    @NotBlank
    private String telephonePCD;
    @NotBlank
    @Email
    private String emailPCD;
    @NotNull
    private Gender genderPCD;
    @NotNull
    private EducationLevel educationLevelPCD;
    @NotNull
    private Boolean employee;
    @NotNull
    private Boolean publicTransportation;

    @NotNull
    @Valid
    private Address addressPCD;

    @Valid
    private AuxiliarPcd auxiliarPCD;

    @Valid
    private InformationDeficiency informationDeficiency;

    private Race race;
    private String bpcNumber;
    private String nit;
    private String susNumber;
    private Boolean hasSons;
    private Boolean neededAssistency;
    private Boolean termsAccepted;
}
