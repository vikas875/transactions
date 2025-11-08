package com.transaction.transactionengines.controllers;

import com.transaction.transactionengines.dto.RegisterRequest;
import com.transaction.transactionengines.dto.ChannelUserDto;
import com.transaction.transactionengines.entity.ChannelUsers;
import com.transaction.transactionengines.repository.ChannelUsersRepository;
import com.transaction.transactionengines.services.authentication.AuthenticationService;
import com.transaction.transactionengines.services.jwt.UserService;
import com.transaction.transactionengines.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.transaction.transactionengines.dto.AuthenticationRequest;
import com.transaction.transactionengines.dto.AuthenticationResponse;

import java.util.Optional;

@RestController
@RequestMapping("/api/transaction/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final ChannelUsersRepository channelUsersRepository;

    // register
    @RequestMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody RegisterRequest registerRequest){
        if (authenticationService.hasCustomerWithEmail(registerRequest.getEmailId()))
            return new ResponseEntity<>("This Email Already Exist !",HttpStatus.NOT_ACCEPTABLE);
        ChannelUserDto createdCustomerDto = authenticationService.createCustomer(registerRequest);
        if (createdCustomerDto == null)
            return new ResponseEntity<>("Customer Not Created, Try Again.", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    }

    // login
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) throws
            BadCredentialsException,
            DisabledException,
            UsernameNotFoundException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                    (authenticationRequest.getEmailId(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException badCredentialsException) {
            throw new BadCredentialsException("Incorrect Email Or Password.");
        }

        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmailId());
        Optional<ChannelUsers> optionalUser = channelUsersRepository.findByEmailId(userDetails.getUsername());
        final String access_token = jwtUtil.generateToken(userDetails);
        final String refresh_token = jwtUtil.generateRefreshToken(userDetails);
        long expiresIn = jwtUtil.getExpiresInSeconds(access_token);
        String issuedAt = jwtUtil.getIssuedAt(access_token).toInstant().toString();
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if (optionalUser.isPresent()) {
            authenticationResponse.setAccess_token(access_token);
            authenticationResponse.setRefresh_token(refresh_token);
            authenticationResponse.setExpires_in(expiresIn);
            authenticationResponse.setIssued_at(issuedAt);
            authenticationResponse.setUserId(optionalUser.get().getUserId());

        }
        return authenticationResponse;
    }


}
