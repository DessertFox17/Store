package com.Vicio.Games.web.controller;

import com.Vicio.Games.domain.dto.AuthenticationRequest;
import com.Vicio.Games.domain.dto.AuthenticationResponse;
import com.Vicio.Games.domain.service.StoreUserDetailService;
import com.Vicio.Games.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private StoreUserDetailService storeUserDetailService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public AuthenticationResponse createToken(@Valid @RequestBody AuthenticationRequest request, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("all or some mandatory fields are incomplete");
        }

        UserDetails userDetails = storeUserDetailService.userAndPasswordValidaion(request.getUsername(), request.getPassword());
        String jwt = jwtUtil.generateToken(userDetails);

        return new AuthenticationResponse(jwt);
    }
}
