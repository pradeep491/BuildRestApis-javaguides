package com.test.blog.security;

import com.test.blog.exception.BlogAPIException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app-jwt-expiration-milliseconds}")
    private Long jwtExpirationDate;

    //To Generate JWT Token
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(key())
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    //to get username from JWT Token
    public String getUserName(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    //To Validate JWT Token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith((SecretKey) key())
                    .build()
                    .parse(token);
            return true;
        } catch (MalformedJwtException e) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Invalid JWT Token");
        } catch (ExpiredJwtException e) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Expired JWT Token");
        } catch (UnsupportedJwtException e) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Unsupported JWT Token");
        } catch (IllegalArgumentException e) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "JWT claims string is null or empty");
        }
    }
}
