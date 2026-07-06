package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Hands on 5 - Create authentication service that returns JWT
 * Steps combined:
 *  1. Create authentication controller and configure it in SecurityConfig
 *  2. Read Authorization header and decode the username and password
 *  3. Generate token based on the user retrieved in the previous step
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private static final String SECRET_KEY = "secretkey";

    // Token expiry: 20 minutes from now
    private static final long EXPIRY_MILLIS = 1200000;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START");
        LOGGER.debug("authHeader : {}", authHeader);

        Map<String, String> map = new HashMap<>();

        String user = getUser(authHeader);
        String token = generateJwt(user);
        map.put("token", token);

        LOGGER.info("END");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("START getUser()");

        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);
        String user = credentials.substring(0, credentials.indexOf(":"));

        LOGGER.debug("user : {}", user);
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.debug("START generateJwt()");

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        // Set the token issue time as current time
        builder.setIssuedAt(new Date());
        // Set the token expiry as 20 minutes from now
        builder.setExpiration(new Date((new Date()).getTime() + EXPIRY_MILLIS));
        builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY);

        String token = builder.compact();
        LOGGER.debug("token : {}", token);

        return token;
    }
}
