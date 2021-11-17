package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final UsuarioService usuarioService;
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UsuarioEntity usuario) {
        Date generateDate = new Date();

        //tempoExpiração
        Date exp = new Date(generateDate.getTime() + Long.parseLong(expiration));

        String jwtToken = Jwts.builder()
                .setIssuer("pessoa-api")
                .setSubject(usuario.getIdUsuario().toString())
                .setIssuedAt(generateDate)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return TOKEN_PREFIX + " " + jwtToken;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if(token != null){
            String user = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            if(user != null){
                return new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        Collections.emptyList()
                );
            }
        }

        return null;
    }
}
