package Acessi.com.Acessi.security;

import Acessi.com.Acessi.security.service.JpaService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

    private TokenUtils tokenUtils;

    private JpaService jpaService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getRequestURI().startsWith("/acessi/login") ||
                request.getRequestURI().equals("/acessi/logout") ||
                request.getRequestURI().equals("/acessi/personalizacao/ativa") ||
                request.getRequestURI().equals("/acessi/departamento") ||
                request.getRequestURI().equals("/acessi/usuario") ||
                request.getRequestURI().startsWith("/swagger-ui")||
                request.getRequestURI().startsWith("/v3/api-docs")){
            System.out.println("Passou");
            filterChain.doFilter(request,response);
            return;
        }
        System.out.println("Passou if");
        String token = tokenUtils.buscarCookie(request);
//        System.out.println("Passou token");
        Boolean valido = tokenUtils.validarToken(token);
//        System.out.println(valido);
        if (valido) {
            System.out.println("Valido");
//            System.out.println("Entrou token valido");
            String usuarioUsername = tokenUtils.getUsuarioUsername(token);
            UserDetails usuario = jpaService.loadUserByUsername(usuarioUsername);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(usuario.getUsername(),
                            null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(
                    usernamePasswordAuthenticationToken
            );
            System.out.println("Foi pro filtro");
            filterChain.doFilter(request, response);
            return;
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
