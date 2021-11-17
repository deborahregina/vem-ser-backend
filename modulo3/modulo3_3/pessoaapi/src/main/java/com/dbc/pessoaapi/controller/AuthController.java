package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.security.TokenService;
import com.dbc.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {
        Optional<UsuarioEntity> usuarioEntityOptional = usuarioService.findByLoginAndSenha(loginDTO.getUsuario(), loginDTO.getSenha());
        if(usuarioEntityOptional.isPresent()){
            return tokenService.getToken(usuarioEntityOptional.get());
        } else {
            throw new RegraDeNegocioException("usuário e senha inválidos");
        }
    }
}
