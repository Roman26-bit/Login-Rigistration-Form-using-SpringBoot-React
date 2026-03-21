package com.example.loginfrom.security;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

@Component
public class TokenInfo {

    private  String Super_Key = "my-super-secret-key-my-super-secret-key";

    public  String generateToken(String email, Role role){
        return Jwts.builder()
                .setSubject(email)
                .claim("role",role.name())
                .claim("permissions",role.getPermissions()
                        .stream()
                        .map(Enum :: name)
                        .toList()
                )
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+60*60*1000))
                .signWith(Keys.hmacShaKeyFor(Super_Key.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims bodyInfo(String token){
        return Jwts.parserBuilder()
                .setSigningKey(Super_Key.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token){
        return  bodyInfo(token).getSubject();
    }

    public String extractRole(String token){
        return bodyInfo(token).get("role", String.class);
    }

    public List extractPermission(String token) {
        return bodyInfo(token).get("permissions", List.class);
    }

    public boolean validateToken(String token){
        return !bodyInfo(token).getExpiration().before(new Date());
    }
}
