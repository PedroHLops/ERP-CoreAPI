package com.Demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.Infra.DTOs.DTOsUser.DataAuthetication;
import com.Demo.Infra.SecurityConfig.TokenService;
import com.Demo.User.Entity.User;
import com.Demo.Infra.DTOs.DTOsUser.DataTokenJWT;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Login")
public class AutheticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> Logar (@RequestBody @Valid DataAuthetication Data) {
        lombok.var Token = new UsernamePasswordAuthenticationToken(Data.login(), Data.password());
        lombok.var authenticate =  manager.authenticate(Token);
        
        lombok.var TokenJWT = tokenService.CreatToken((User) authenticate.getPrincipal());
        return ResponseEntity.ok(new DataTokenJWT(TokenJWT));
    }

}
