package Acessi.com.Acessi.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Date;

public class ResetPasswordTokenDTO {

    @NotBlank
    private String email;
    @NotBlank
    private String token;
    @NotBlank
    private LocalDateTime dataExpiracao;

}
