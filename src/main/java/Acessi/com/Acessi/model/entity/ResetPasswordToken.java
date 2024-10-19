package Acessi.com.Acessi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ResetPasswordToken")
@Data
public class ResetPasswordToken
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_expiracao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataExpiracao;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(nullable = false, length = 150)
    private String token;

    public ResetPasswordToken() {
    }

    public ResetPasswordToken(LocalDateTime  dataExpiracao, String email, String token) {
        this.dataExpiracao = dataExpiracao;
        this.email = email;
        this.token = token;
    }

}
