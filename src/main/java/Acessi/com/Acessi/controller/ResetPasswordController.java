package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.model.service.AvaliationLocalService;
import Acessi.com.Acessi.model.service.ResetPasswordService;
import Acessi.com.Acessi.model.service.UserService;
import Acessi.com.Acessi.security.TokenUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/reset-password")
public class ResetPasswordController {

    private ResetPasswordService resetPasswordService;

    private UserService userService;


    @PostMapping("/validate-token-reset-password")
    public ResponseEntity<Boolean> validateToken(
            @RequestParam String token,
            @RequestParam String email)
    {

        boolean isValid = resetPasswordService.validateToken(token, email);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/send-email-reset-password")
    public ResponseEntity<Boolean> validateToken(
            @RequestParam String email)
    {
        boolean isEmailSend = resetPasswordService.sendResetPasswordEmail(email);
        return ResponseEntity.ok(isEmailSend);
    }

    @PostMapping("/change-password")
    public ResponseEntity<Boolean> changePassword(
            @RequestParam String password,
            @RequestParam String email)
    {
        var isReseted = resetPasswordService.resetPassword(userService, email, password);
        return ResponseEntity.ok(isReseted);
    }


}
