package com.hamza.tasks_api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private Key getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String username) {

        long nowMillis = System.currentTimeMillis();

        Date now = new Date(nowMillis);
        Date expirationDate = new Date(nowMillis + expiration);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(getSigningKey())
                .compact();
    }

    public Claims extractAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public String extractUsernameFromToken(String token) {
        return extractAllClaimsFromToken(token)
                .getSubject();
    }

    private boolean isTokenExpired(String token) {
        try {
            Date expiration = extractAllClaimsFromToken(token).getExpiration();
            return expiration.before(new Date());
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            // Specifically caught if only the time is the issue
            return true;
        } catch (Exception e) {
            // Other issues (signature, etc.)
            return true;
        }
    }

    public boolean isTokenValid(String token, String username) {
        return (!isTokenExpired(token) && extractUsernameFromToken(token).equals(username));
    }


}
