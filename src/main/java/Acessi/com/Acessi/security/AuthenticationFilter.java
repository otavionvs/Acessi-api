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
                request.getRequestURI().startsWith("/acessi/user") ||
                request.getRequestURI().startsWith("/acessi/company") ||
                request.getRequestURI().startsWith("/acessi/avaliation") ||
                request.getRequestURI().startsWith("/acessi/reset-password") ||
                request.getRequestURI().startsWith("/swagger-ui")||
                request.getRequestURI().startsWith("/v3/api-docs")){
//            System.out.println("Passou");
            filterChain.doFilter(request,response);
            return;
        }
//        System.out.println("Passou if");
        String token = tokenUtils.getCookie(request);
        Boolean valido = tokenUtils.validateToken(token);
        if (valido) {
//            System.out.println("Valido");
            String emailUser = tokenUtils.getUserEmail(token);
            UserDetails user = jpaService.loadUserByUsername(emailUser);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(),
                            null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(
                    usernamePasswordAuthenticationToken
            );
//            System.out.println("Foi pro filtro");
            filterChain.doFilter(request, response);
            return;
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
