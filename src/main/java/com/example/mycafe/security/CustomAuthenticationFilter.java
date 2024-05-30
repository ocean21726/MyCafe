package com.example.mycafe.security;

import com.example.mycafe.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;


public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Value("${jwt.token.key}")
    private String secretKey;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authResult) throws IOException, ServletException {
        CustomUserDetails customUserDetails = (CustomUserDetails) authResult.getPrincipal();
        Claims claims = Jwts.claims().setSubject(customUserDetails.getUsername());
        String jwt = Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + (1000L*100)))
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        response.addHeader("Authorization", "Bearer "+jwt);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest;
        try {
            authRequest = getAuthRequest(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Authentication authentication = getAuthenticationManager().authenticate(authRequest);
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    public UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(request.getInputStream(), User.class);
            return new UsernamePasswordAuthenticationToken(user.getPhoneNumber(), user.getPw());
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage(), e.getCause());
        }
    }
}
