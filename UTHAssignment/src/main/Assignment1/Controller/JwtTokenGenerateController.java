package com.Assignment1.Controller;

import com.Assignment1.JwtAuthentication.JwtUtil;
import com.Assignment1.Models.AuthorizationBody;
import com.Assignment1.ParamCheck.ParamCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtTokenGenerateController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/token")
    public String generateToken(@RequestBody AuthorizationBody authorizationBody) throws Exception {
       
        ParamCheck.checkAuthorizationBody(authorizationBody);

            //Authenticate user.
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authorizationBody.getUserName(), authorizationBody.getPassword()));

        //If user is authenticated.
        //Generate token from username.
        return jwtUtil.generateToken(authorizationBody.getUserName());

    }
}
