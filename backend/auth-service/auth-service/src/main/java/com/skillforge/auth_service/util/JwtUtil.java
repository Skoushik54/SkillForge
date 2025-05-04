package com.skillforge.auth_service.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secretKey;
    private Key getSignKey(){
        byte[] keyBytes= Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Value("${jwt.expiration}")
    private long expirationTime;
    public String generateToken(String email,String role){
        return Jwts.builder()
                .setSubject(email)
                .claim("role",role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String extractEmail(String token){
        return extractClaims(token,Claims::getSubject);
    }
    public String extractRole(String token){
        return extractClaims(token,claims -> claims.get("role",String.class));
    }

    private <T> T extractClaims(String token, ClaimsResolver<T> claimsResolver) {
        final Claims claims=extractAllClaims(token);
        return claimsResolver.resolve(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @FunctionalInterface
    interface ClaimsResolver<T>{
        T resolve(Claims claims);
    }
    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
       return extractClaims(token,Claims::getExpiration);
    }
    public boolean validateToken(String token,String email){
        return email.equals(extractEmail(token)) && !isTokenExpired(token);
    }
}
