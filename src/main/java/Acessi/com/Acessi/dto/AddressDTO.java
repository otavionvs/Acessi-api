package Acessi.com.Acessi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class AddressDTO {
    @NotBlank
    private String cityAddress;
    @NotBlank
    private String streetAddress;
    @NotBlank
    private String neighborhoodAddress;
    @NotNull
    @Positive
    private Integer numberAddress;
    private String complementAddress;
    @NotNull
    private String cepAddress;
    private Integer userId;
}
