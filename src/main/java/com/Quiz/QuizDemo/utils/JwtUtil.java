package com.Quiz.QuizDemo.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "91575e7e59241410ceffeb2ab7356ffe8aec58609334cda97e257ee08ea46be28f7e3b1317f16b98f4404cc3b8f8dafb8ad9d18078588167c24cbee8ce1d82ae";
    private static final long EXPIRATION_TIME = 86400000L; // 1 day

    // Generate the signing key from the secret
    private static Key getSigningKey() {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());
    }

    // Generate a JWT token
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, getSigningKey())
                .compact();
    }

    // Extract the username from a JWT token
    public static String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
