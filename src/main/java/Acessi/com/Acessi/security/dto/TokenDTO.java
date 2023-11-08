package Acessi.com.Acessi.security.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class TokenDTO {
    @NonNull
    private String type;
    @NonNull
    private String token;
}
