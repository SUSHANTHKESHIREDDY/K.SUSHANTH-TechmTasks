package com.app.config;

import com.app.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Autowired
    public JwtAuthenticationFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            System.out.println("JwtAuthenticationFilter Called");

            String authHeader = request.getHeader("Authorization");
            logger.debug("JwtAuthenticationFilter - Authorization Header: {}", authHeader);

            String token = null;
            String username = null;

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
                logger.debug("JwtAuthenticationFilter - Extracted Token: {}", token);
                System.out.println("JwtAuthenticationFilter - Before extractUsername"); // Add this line
                username = jwtUtil.extractUsername(token);
                logger.debug("JwtAuthenticationFilter - Extracted username from JWT: {}", username);
            } else {
                logger.debug("JwtAuthenticationFilter - No Bearer token found in request");
            }

            System.out.println("Extracted Username: " + username);
            System.out.println("Extracted Token: " + token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                logger.debug("JwtAuthenticationFilter - User loaded: {}", userDetails.getUsername());

                if (jwtUtil.validateToken(token, userDetails.getUsername())) {
                    logger.debug("JwtAuthenticationFilter - JWT validation successful!");

                    String extractedRole = jwtUtil.extractRole(token);
                    logger.debug("JwtAuthenticationFilter - Extracted role from JWT: {}", extractedRole);

                    List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(extractedRole));

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, authorities);
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    logger.debug("JwtAuthenticationFilter - SecurityContextHolder set with authentication: {}", authToken);

                    System.out.println("SecurityContext Authentication: " + SecurityContextHolder.getContext().getAuthentication());
                } else {
                    logger.debug("JwtAuthenticationFilter - JWT validation failed!");
                }
            }

            chain.doFilter(request, response);
        } catch (Exception e) {
            logger.error("JwtAuthenticationFilter - Exception in doFilterInternal: {}", e.getMessage());
            e.printStackTrace(); // Print the stack trace for more details
            chain.doFilter(request, response); // Continue the filter chain
        }
    }
}