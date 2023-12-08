package io.espinoleandroo.java.Spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.espinoleandroo.java.Spring.domain.dto.AuthenticationRequest;
import io.espinoleandroo.java.Spring.domain.dto.AuthenticationResponse;
import io.espinoleandroo.java.Spring.domain.service.UserDetailsService;
import io.espinoleandroo.java.Spring.web.security.JWTUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			UserDetails userDetails = detailsService.loadUserByUsername(request.getUsername());
			String jwt = jwtUtil.generateToken(userDetails);
			
			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(jwt), HttpStatus.OK);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}
