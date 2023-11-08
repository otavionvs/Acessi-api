package Acessi.com.Acessi.security.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginUserDTO {
    @NonNull
    private String emailUser;
    @NonNull
    private String passwordUser;
}
