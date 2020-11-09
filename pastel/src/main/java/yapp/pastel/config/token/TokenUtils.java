package yapp.pastel.config.token;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import yapp.pastel.domain.user.User;

@Component
@Service
public class TokenUtils {

  // @Value("${jwt.signingKey}")
  private String signingKey = "keykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykey";

  // @Value("${jwt.subject}")
  private String subject = "subject";

  public String createAccessToken(User user) {
    return Jwts.builder()
        .setId(UUID.randomUUID().toString())
        .setSubject(subject)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
        .claim("email", user.getEmail())
        .claim("roles", user.getRole())
        .compact();
  }

  public String createRefreshToken(User user) {
    return Jwts.builder()
        .signWith(SignatureAlgorithm.HS512, signingKey.getBytes())
        .setId(UUID.randomUUID().toString())
        .setSubject(subject)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24*7))
        .claim("email", user.getEmail())
        .claim("roles", user.getRole())
        .compact();
  }

  private Claims claims(String jwt) {
    return Jwts.parser()
          .setSigningKey(signingKey.getBytes())
          .parseClaimsJws(jwt)
          .getBody();
  }
  
  public String getEmail(String jwt) {
    return (String) claims(jwt)
        .get("email");
  }

  public String getId(String jwt) {
    return claims(jwt)
        .getId();
  }

  public String getRoles(String jwt) {
    return (String) claims(jwt)
        .get("roles");
  }
}
