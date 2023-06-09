package com.gsc.portalapps.controller;

import com.gsc.portalapps.dto.UserDTO;
import com.gsc.portalapps.security.JwtAuthenticationToken;
import com.gsc.portalapps.security.TokenProvider;
import com.gsc.portalapps.security.UserPrincipal;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(value = "",tags = "EMV - Authentication")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    private final TokenProvider tokenProvider;

    @PostMapping("/sign-in")
    public UserDTO createAuthenticationToken(@RequestHeader("loginToken") String loginToken){

        Authentication authentication = authenticationManager.authenticate(new JwtAuthenticationToken(loginToken));
        String token = tokenProvider.createToken(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return new UserDTO(token, userPrincipal.getRoles(), userPrincipal.getClientId());
    }
}
