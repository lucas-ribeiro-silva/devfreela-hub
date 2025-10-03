package com.devfreelahub.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.devfreelahub.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}") // Injeta a chave secreta do application.properties
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("devfreela-hub-api") // Quem está emitindo o token
                    .withSubject(user.getEmail()) // O "dono" do token (usuário)
                    .withExpiresAt(getExpirationDate()) // Data de expiração
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("devfreela-hub-api")
                    .build()
                    .verify(token) // Valida o token
                    .getSubject(); // Retorna o "dono" do token (o email do usuário)
        } catch (JWTVerificationException exception) {
            return ""; // Retorna vazio se o token for inválido
        }
    }

    private Instant getExpirationDate() {
        // Define a expiração do token para 2 horas a partir de agora
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}