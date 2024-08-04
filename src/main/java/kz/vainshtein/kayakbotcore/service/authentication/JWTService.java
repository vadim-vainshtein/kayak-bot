package kz.vainshtein.kayakbotcore.service.authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import kz.vainshtein.kayakbotcore.entity.security.User;
import kz.vainshtein.kayakbotcore.service.DateTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JWTService {

    // TODO: move to config
    private static final Duration TOKEN_LIFE_TIME = Duration.ofMinutes(30);
    // TODO: remove from code and use env. vars
    private static final String SECRET = "secret_secretsecret_secretsecret_secret";

    private final DateTimeService dateTimeService;

    // TODO: replace deprecated
    public String generateToken(User user) {

        var issuedAt = dateTimeService.now();

        return Jwts.builder()
                   .claims(getExtraClaims(user))
                   .subject(user.getUsername())
                   .issuedAt(Date.from(issuedAt))
                   .expiration(Date.from(issuedAt.plus(TOKEN_LIFE_TIME)))
                   .signWith(generateSignature(), SignatureAlgorithm.HS256)
                   .compact();
    }

    private Key generateSignature() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    private Map<String, Object> getExtraClaims(User user) {
        var extraClaims = new HashMap<String, Object>();

        extraClaims.put("username", user.getUsername());
        extraClaims.put("role", user.getRole());

        return extraClaims;
    }

    // TODO: replace deprecated
    public String extractUsername(String token) {
        return Jwts.parser()
                   .setSigningKey(generateSignature())
                   .build()
                   .parseSignedClaims(token)
                   .getPayload()
                   .getSubject();
    }
}
