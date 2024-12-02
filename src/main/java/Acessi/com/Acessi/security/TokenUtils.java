package Acessi.com.Acessi.security;

import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.security.users.UserJpa;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.util.WebUtils;

import java.util.Date;

public class TokenUtils {
    private final String senhaForte = "c127a7b6adb013a5ff879ae71afa62afa4b4ceb72afaa54711dbcde67b6dc325";
    public String generateToken(Authentication authentication) {
        UserJpa userJpa = (UserJpa) authentication.getPrincipal();
        return Jwts.builder()
                .setIssuer("Acessi")
                .setSubject(userJpa.getUser().getEmailUser())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 7200000))
                .signWith(SignatureAlgorithm.HS256, senhaForte)
                .compact();
    }


    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(senhaForte).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Cookie generateCookie(Authentication authentication){
        Cookie cookie = new Cookie("token", generateToken(authentication));
        cookie.setPath("/");
        cookie.setMaxAge(7200);
        return cookie;
    }

    public String getUserEmail(String token) {
        String user = Jwts.parser()
                .setSigningKey(senhaForte)
                .parseClaimsJws(token)
                .getBody().getSubject();

        return user;
    }

    public String getUserEmailByRequest(HttpServletRequest request){
        String token = getCookie(request);
        return getUserEmail(token);
    }

    public String getCookie(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request,"token");
        if(cookie != null){
            return cookie.getValue();
        }
        throw new RuntimeException("Cookie não encontrado");
    }
}
