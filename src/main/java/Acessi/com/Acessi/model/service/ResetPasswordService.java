package Acessi.com.Acessi.model.service;

import Acessi.com.Acessi.model.entity.ResetPasswordToken;
import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.repository.ResetPasswordRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ResetPasswordService {
    private ResetPasswordRepository resetPasswordRepository;
    private final JavaMailSender mailSender;

    public Optional<ResetPasswordToken> findResetByEmail(String email)
    {
        return resetPasswordRepository.findResetByEmail(email);
    }

    public Optional<ResetPasswordToken> findAllByEmailOrderByDataExpiracaoDesc(String email)
    {
        List<ResetPasswordToken> tokens =  resetPasswordRepository.findAllByEmailOrderByDataExpiracaoDesc(email);
        return tokens.stream().findFirst();
    }
    public ResetPasswordToken save(ResetPasswordToken entity) {
        return resetPasswordRepository.save(entity);
    }
    public boolean validateToken(String token, String email)
    {
        try
        {
            Optional<ResetPasswordToken> reset = findAllByEmailOrderByDataExpiracaoDesc(email);
            if (reset.isPresent()) {
                LocalDateTime dataHoraAtual = LocalDateTime.now();
                return reset.get().getToken().equals(token) && reset.get().getDataExpiracao().isAfter(dataHoraAtual);
            }
            return  false;
        }catch (Exception ex)
        {
            return false;
        }
    }

    public boolean sendResetPasswordEmail(String email)
    {
        Random random = new Random();
        int token = 100000 + random.nextInt(900000);
        String tokenGerado = String.valueOf(token);

        LocalDateTime dataExpiracao = LocalDateTime.now().plusMinutes(5);

        ResetPasswordToken resetToken = new ResetPasswordToken(dataExpiracao, email, tokenGerado);
        save(resetToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("mia@movtech.com.br");
        mailMessage.setTo(email);
        mailMessage.setSubject("Reset de Senha - Acessi");
        mailMessage.setText("Seu token de reset de senha é: " + token + ". Ele expira em 5 minutos.");

        try {
            mailSender.send(mailMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean  resetPassword(UserService userService, String email, String password)
    {
        Optional<User> user = userService.findByEmailUser(email);
        if(user.isEmpty()) return false;

        try
        {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            userService.changePassword(user.get(), encoder.encode(password));
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }
}
