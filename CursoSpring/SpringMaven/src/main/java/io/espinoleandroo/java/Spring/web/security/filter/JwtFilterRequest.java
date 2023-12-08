package io.espinoleandroo.java.Spring.web.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.espinoleandroo.java.Spring.domain.service.UserDetailsService;
import io.espinoleandroo.java.Spring.web.security.JWTUtil;

@Component
public class JwtFilterRequest extends OncePerRequestFilter{

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserDetailsService detailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader = request.getHeader("Authorization");
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
			String jwt = authorizationHeader.substring(7);
			String username = jwtUtil.extractUsername(jwt);
			
			if(username !=  null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = detailsService.loadUserByUsername(username);
				
				if(jwtUtil.validateToken(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
		}
		
		filterChain.doFilter(request, response);
	}

	
}
