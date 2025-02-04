package com.mindlink.controllers;

import com.mindlink.models.dtos.userdtos.DoctorRegistrationRequest;
import com.mindlink.models.dtos.userdtos.LoginRequest;
import com.mindlink.models.dtos.userdtos.PatientRegistrationRequest;
import com.mindlink.repositories.UserRepository;
import com.mindlink.services.servicesImpl.UserServiceImpl;
import com.mindlink.utils.JwtService;
import com.mindlink.utils.respnses.AuthResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserServiceImpl userServiceImpl;

    public AuthenticationController(AuthenticationManager authenticationManager,
            UserRepository userRepository,
            JwtService jwtService,
            UserServiceImpl userServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);

        return ResponseEntity.ok(new AuthResponse(jwtToken));
    }

    @PostMapping("/register/patient")
    public ResponseEntity<?> registerPatient(@Valid @RequestBody PatientRegistrationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        userServiceImpl.createPatient(request);

        return new ResponseEntity<>("Patient registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/register/doctor")
    public ResponseEntity<?> registerDoctor(@Valid @RequestBody DoctorRegistrationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        userServiceImpl.createDoctor(request);

        return ResponseEntity.ok("Doctor registered successfully");
    }
}
