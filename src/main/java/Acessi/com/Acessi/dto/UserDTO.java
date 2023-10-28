package Acessi.com.Acessi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserDTO {
    @NotBlank
    private String nameUser;
    @NotBlank
    private String emailUser;
    @NotBlank
    private String passwordUser;
}
