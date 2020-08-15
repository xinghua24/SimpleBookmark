package com.xinghua24.authservice.controller;

import com.xinghua24.authservice.config.JwtAuthenticationConfig;
import com.xinghua24.authservice.model.AuthenticationRequest;
import com.xinghua24.authservice.model.AuthenticationResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAuthenticationConfig jwtAuthenticationConfig;
    
    // POST http://localhost:8080/login
    // Payload {"username": "foo", "password": "foo" }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch(BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String jwt = createToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    private String createToken(UserDetails userDetails) {
    	Map<String,Object> claims = new HashMap<>();
    	claims.put("authorities", userDetails.getAuthorities().stream()
    			.map(grantedAuthority -> grantedAuthority.getAuthority())
    			.collect(Collectors.joining(" ")));
        return Jwts.builder().setClaims(claims)
        		.setSubject(userDetails.getUsername())
        		.setIssuedAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(LocalDateTime.now().plusHours(1).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS256, jwtAuthenticationConfig.getSecret()).compact();
    }
}
