package Acessi.com.Acessi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CompanyDTO {
    @NotBlank
    private String companyName;
    @NotBlank
    private String cnpjCompany;
//    private String siteCompany;
//    private String areaCompany;
    @NotBlank
    private String telephoneCompany;
    @NotBlank
    @Email
    private String emailCompany;
    @Valid
    private UserDTO userCompany;
}
