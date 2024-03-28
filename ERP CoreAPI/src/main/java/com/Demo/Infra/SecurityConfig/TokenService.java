package com.Demo.Infra.SecurityConfig;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Demo.User.Entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;


@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String Secret;

    public String CreatToken(User user) {
        try {
            lombok.var algorithm = Algorithm.HMAC256(Secret);
            return JWT.create()
                .withIssuer("ERP CoreAPI")
                .withSubject(user.getLogin())
                .withClaim("id", user.getID())
                .withExpiresAt(TokenTime())
                .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    public String getSubject(String TokenJWT) {
        try {
            lombok.var algorithm = Algorithm.HMAC256(Secret);
            return JWT.require(algorithm)
                .withIssuer("ERP CoreAPI")
                .build()
                .verify(TokenJWT)
                .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token inválido ou expirado.", exception);
        }
    }

    private Instant TokenTime() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
