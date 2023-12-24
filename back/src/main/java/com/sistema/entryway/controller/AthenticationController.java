package com.sistema.entryway.controller;

import com.sistema.entryway.config.security.TokenService;
import com.sistema.entryway.dto.AuthenticationDTO;
import com.sistema.entryway.dto.LoginResponseDTO;
import com.sistema.entryway.model.Subject;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AthenticationController(AuthenticationManager authenticationManager,
                                   TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                authenticationDTO.login(),
                authenticationDTO.password()
        );
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Subject) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
