package com.binay.userdetails.rest.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.binay.userdetails.exception.UserNotFoundException;
import com.binay.userdetails.persistence.repository.UserRepository;
import com.binay.userdetails.rest.dto.AuthenticationRequest;
import com.binay.userdetails.rest.security.jwt.JwtTokenManager;

@RestController
public class AuthenticationContoller {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenManager jwtTokenManager;

    @Autowired
    UserRepository usersRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/authenticate")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) {

        try {
        	String username = data.getUserName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenManager.createToken(username, this.usersRepository.getUserByUserName(username)
            		.orElseThrow(() -> new UserNotFoundException("No User found with id :" + username))
            		.getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
    
    @GetMapping("/me")
    public ResponseEntity currentUser(@AuthenticationPrincipal UserDetails userDetails){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userDetails.getUsername());
        model.put("roles", userDetails.getAuthorities()
            .stream()
            .map(a -> ((GrantedAuthority) a).getAuthority())
            .collect(Collectors.toList())
        );
        return ResponseEntity.ok(model);
    }
}