package com.gerenciador.eventos.service;

import java.util.Date;
import org.springframework.stereotype.Service;
import com.gerenciador.eventos.model.Administrador;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
    
    private String secret = "MinhaChaveSecreta123";
    private long expiration = 86400000;
    
    public String gerarToken(Administrador admin) {
        Date hoje = new Date(); 
        Date dataExpiracao = new Date(hoje.getTime() + expiration);
        
        return Jwts.builder()
                .setIssuer("API gerenciador de eventos")
                .setSubject(admin.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    
    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdAdministrador(String token) {
        String subject = Jwts.parser()
                .setSigningKey(this.secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return Long.parseLong(subject); 
    }
}