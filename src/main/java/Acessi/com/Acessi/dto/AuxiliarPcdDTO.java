package Acessi.com.Acessi.dto;

import Acessi.com.Acessi.model.entity.Address;
import Acessi.com.Acessi.model.enums.FamilyBond;
import Acessi.com.Acessi.model.enums.Gender;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

@Getter
public class AuxiliarPcdDTO {
    @NotBlank
    private String nameAuxiliar;
    @NotBlank
    private String cpfAuxiliar;
    @NotNull
    private Date birthDateAuxiliar;
    @NotBlank
    private String telephoneAuxiliar;
    @NotBlank
    @Email
    private String emailAuxiliar;
    @NotNull
    private Gender genderAuxiliar;
    @NotNull
    private FamilyBond familyBond;
    @Valid
    private Address addressAuxiliar;
}
