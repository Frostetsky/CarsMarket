package com.carmarket.app.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.experimental.UtilityClass;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@UtilityClass
public class JwtUtil {

    public String SECRET = "SecretKeyToGenJWTs";

    public String ID_TOKEN = "id_token";

    public String TOKEN_PREFIX = "Bearer ";

    public String generateToken(String username) {

        var expTime = LocalDateTime.now()
                .plus(5, ChronoUnit.DAYS)
                .withNano(0);

        return JWT.create()
                .withSubject(username)
                .withExpiresAt(Date.from(expTime.atZone(ZoneId.systemDefault()).toInstant()))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));
    }
}
