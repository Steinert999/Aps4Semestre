package br.com.ies.candyShop.security;

import br.com.ies.candyShop.dto.UserDTO;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    public String generateToken(Authentication authentication){
        UserDTO userDTO = (UserDTO) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(Long.toString(userDTO.getId()))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Long getUserIdFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Assinatura JWT inválida");
        } catch (MalformedJwtException ex) {
            logger.error("Token JWT inválido");
        } catch (UnsupportedJwtException ex) {
            logger.error("Token JWT não suportado");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT Claims está vazio");
        }
        return false;
    }
}
