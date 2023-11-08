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
@RequestMapping("/acessi")
public class AuthenticationController {
    private TokenUtils tokenUtils = new TokenUtils();
    @Autowired
    private JpaService jpaService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login/verify-token")
    public ResponseEntity<Object> autenticacao(HttpServletRequest request) {
        Boolean valido = false;
        UserDetails usuario = null;
        try {
            String token = tokenUtils.buscarCookie(request);
            valido = tokenUtils.validarToken(token);
            if (valido) {
                String usuarioUsername = tokenUtils.getUsuarioUsername(token);
                usuario = jpaService.loadUserByUsername(usuarioUsername);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(valido);
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @GetMapping("/login/return-user-logged")
    public ResponseEntity<Object> returnUser(HttpServletRequest request) {
        String token = tokenUtils.buscarCookie(request);
        String usuarioUsername = tokenUtils.getUsuarioUsername(token);
        UserJpa usuario = (UserJpa) jpaService.loadUserByUsername(usuarioUsername);
        return ResponseEntity.status(HttpStatus.OK).body(usuario.getUser());
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        // Lógica de logout, como invalidar a sessão e remover o cookie de autenticação
        request.getSession().invalidate();
        Cookie cookie = new Cookie("jwt", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        // Redirecionar para a página de login ou retornar uma resposta personalizada
        return ResponseEntity.ok("Logout realizado com sucesso");
    }

    @PostMapping("/login/auth")
    public ResponseEntity<Object> autenticacao(
            @RequestBody @Valid LoginUserDTO usuarioDTO,
            HttpServletResponse response) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        usuarioDTO.getEmailUser(), usuarioDTO.getPasswordUser());

        Authentication authentication =
                authenticationManager.authenticate(authenticationToken);

        if (authentication.isAuthenticated()) {
            response.addCookie(tokenUtils.gerarCookie(authentication));
            UserJpa userJpa = (UserJpa) authentication.getPrincipal();
//            if(userJpa.getUser().getPrimeiroAcesso() == false) {
//                Usuario usuario = userJpa.getUsuario();
//                usuario.setPrimeiroAcesso(true);
//                jpaService.pessoaRepository.save(usuario);
//                usuario.setPrimeiroAcesso(false);
//            }
            return ResponseEntity.ok(userJpa.getUser());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
