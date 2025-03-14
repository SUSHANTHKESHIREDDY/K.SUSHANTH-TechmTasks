package com.app.utility;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Base64;

@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private final Key SECRET_KEY;

    public JwtUtil(@Value("${jwt.secret}") String secretKey) {
        this.SECRET_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secretKey));
    }

    public String generateToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SECRET_KEY)
                .compact();
        logger.debug("JwtUtil - Generated Token: {}", token);
        return token;
    }

    public String extractUsername(String token) {
        logger.debug("JwtUtil - Raw Token (extractUsername): {}", token); // Add this line
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            logger.debug("JwtUtil - Parsed Claims (extractUsername): {}", claimsJws); // Add this line

            String username = claimsJws.getBody().getSubject();
            logger.debug("JwtUtil - Extracted username: {}", username);
            return username;
        } catch (Exception e) {
            logger.error("JwtUtil - Error extracting username: {}", e.getMessage());
            return null;
        }
    }

    public String extractRole(String token) {
        logger.debug("JwtUtil - Raw Token (extractRole): {}", token); // Add this line
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            logger.debug("JwtUtil - Parsed Claims (extractRole): {}", claimsJws); // Add this line

            String role = claimsJws.getBody().get("role", String.class);
            logger.debug("JwtUtil - Extracted role: {}", role);
            return role;
        } catch (Exception e) {
            logger.error("JwtUtil - Error extracting role: {}", e.getMessage());
            return null;
        }
    }

    public boolean validateToken(String token, String username) {
        logger.debug("JwtUtil - Validating Token: {}", token); // Add this line
        logger.debug("JwtUtil - Validating Token for username: {}", username); // Add this line

        try {
            boolean isValid = (username.equals(extractUsername(token)) && !isTokenExpired(token));
            logger.debug("JwtUtil - Token validation result for user {}: {}", username, isValid);
            return isValid;
        } catch (Exception e) {
            logger.error("JwtUtil - Error validating token: {}", e.getMessage());
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration()
                    .before(new Date());
        } catch (ExpiredJwtException e) {
            logger.debug("JwtUtil - Token expired: {}", e.getMessage());
            return true;
        } catch (Exception e) {
            logger.error("JwtUtil - Error checking token expiration: {}", e.getMessage());
            return true;
        }
    }
}