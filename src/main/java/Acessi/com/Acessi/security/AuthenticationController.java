package Acessi.com.Acessi.security;

import Acessi.com.Acessi.security.dto.LoginUserDTO;
import Acessi.com.Acessi.security.service.JpaService;
import Acessi.com.Acessi.security.users.UserJpa;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthenticationController {
    private TokenUtils tokenUtils = new TokenUtils();
    @Autowired
    private JpaService jpaService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login/verify-token")
    public ResponseEntity<Object> authentication(HttpServletRequest request) {
        Boolean valid = false;
        UserDetails user = null;
        try {
            String token = tokenUtils.getCookie(request);
            valid = tokenUtils.validateToken(token);
            if (valid) {
                String emailUser = tokenUtils.getUserEmail(token);
                user = jpaService.loadUserByUsername(emailUser);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(valid);
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/login/return-user-logged")
    public ResponseEntity<Object> returnUser(HttpServletRequest request) {
        String token = tokenUtils.getCookie(request);
        String emailUser = tokenUtils.getUserEmail(token);
        UserJpa user = (UserJpa) jpaService.loadUserByUsername(emailUser);
        return ResponseEntity.status(HttpStatus.OK).body(user.getUser());
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        // Lógica de logout, como invalidar a sessão e remover o cookie de autenticação
        request.getSession().invalidate();
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        // Redirecionar para a página de login ou retornar uma resposta personalizada
        return ResponseEntity.ok("Logout realizado com sucesso");
    }

    @PostMapping("/login/auth")
    public ResponseEntity<Object> authentication(
            @RequestBody @Valid LoginUserDTO loginUserDTO,
            HttpServletResponse response) {
        System.out.println("Entrou");
        UsernamePasswordAuthenticationToken authenticationToken = 
                new UsernamePasswordAuthenticationToken(
                        loginUserDTO.getEmailUser(), loginUserDTO.getPasswordUser());

        Authentication authentication =
                authenticationManager.authenticate(authenticationToken);

        if (authentication.isAuthenticated()) {
            response.addCookie(tokenUtils.generateCookie(authentication));
            UserJpa userJpa = (UserJpa) authentication.getPrincipal();
            return ResponseEntity.ok(userJpa.getUser());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
