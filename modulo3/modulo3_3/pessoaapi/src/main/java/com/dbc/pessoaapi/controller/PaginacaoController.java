package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/paginacao")
@Validated
@Slf4j
@RequiredArgsConstructor
public class PaginacaoController {

    public final ContatoRepository contatoRepository;
    public final EnderecoRepository enderecoRepository;

    @GetMapping("/lista-contatos-descricao-paginada")
    public Page<ContatoEntity> listaContatosOrdenadoDescricao(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina, // pagina que eu quero
                quantidadeDeRegistrosPorPagina, //quantidade de registros por pagina
                Sort.by("descricao")); //ordenação (opcional)
        Page<ContatoEntity> paginaDoBanco = contatoRepository.findAll(pageable);
        return paginaDoBanco;
    }

    @GetMapping("/lista-enderecos-cep-paginado")
    public Page<EnderecoEntity> listaEnderecosOrdenadosCEP(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina, // pagina que eu quero
                quantidadeDeRegistrosPorPagina, //quantidade de registros por pagina
                Sort.by("cep")); //ordenação (opcional)
        Page<EnderecoEntity> paginaDoBanco = enderecoRepository.findAll(pageable);
        return paginaDoBanco;
    }

    @GetMapping("/lista-enderecos-pais-paginado")
    public Page<EnderecoEntity> listaEnderecosOrdenadosPais(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina, @RequestParam String pais){
        Pageable pageable = PageRequest.of(pagina,
                quantidadeDeRegistrosPorPagina); //ordenação (opcional)
        Page<EnderecoEntity> paginaDoBanco = enderecoRepository.findByPaisJPQL(pais.toUpperCase(Locale.ROOT),pageable);
        return paginaDoBanco;
    }

}
