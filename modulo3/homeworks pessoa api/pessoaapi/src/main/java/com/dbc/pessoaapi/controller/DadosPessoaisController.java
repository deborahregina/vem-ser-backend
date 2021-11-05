package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.service.DadosPessoaisService;
import feign.RequestLine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@Validated
@Slf4j
@RequiredArgsConstructor
public class DadosPessoaisController {

    private final DadosPessoaisService dadosPessoaisService;
    private final DadosPessoaisClient dadosPessoaisClient;

    @GetMapping("/dados-pessoais")
    public List<DadosPessoaisDTO> listarDadosPessoais() {
        return dadosPessoaisClient.listar();
    }

    @PostMapping
    public DadosPessoaisDTO create(@RequestBody @Valid DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return dadosPessoaisService.create(dadosPessoaisDTO);
    }

    @GetMapping("/{cpf}")
    public DadosPessoaisDTO getPorCpf(@PathVariable("cpf") String cpf) throws Exception {
        return dadosPessoaisService.getPorCpf(cpf);
    }

    @DeleteMapping("{cpf}")
    public DadosPessoaisDTO delete(@PathVariable("cpf") String cpf) throws Exception {
        return dadosPessoaisService.delete(cpf);
    }
}
