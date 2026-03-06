package com.gerenciador.eventos.config;

import java.io.IOException;
import java.util.Collections;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import com.gerenciador.eventos.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends OncePerRequestFilter {
    
    private TokenService tokenService;
    
    public AuthenticationFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String token = recuperarToken(request);
        
        if (token != null) {
            boolean valido = tokenService.isTokenValido(token);
            if (valido) {
                autenticarCliente(token);
            }
        }
        
        filterChain.doFilter(request, response);
    }
    
    private void autenticarCliente(String token) {
        Long idAdmin = tokenService.getIdAdministrador(token);
        
        UsernamePasswordAuthenticationToken authentication = 
                new UsernamePasswordAuthenticationToken(idAdmin, null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    
    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        
        return token.substring(7);
    }
}