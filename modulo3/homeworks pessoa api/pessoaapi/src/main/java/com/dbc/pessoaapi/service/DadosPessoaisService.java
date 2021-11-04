package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DadosPessoaisService {

    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final DadosPessoaisClient dadosPessoaisClient;


    public List<DadosPessoaisDTO> listar() {
        return dadosPessoaisClient.listar();
    }

    public DadosPessoaisDTO create(DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return dadosPessoaisClient.create(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO getPorCpf(String cpf) {
        return dadosPessoaisClient.getPorCpf(cpf);
    }

    public DadosPessoaisDTO delete(String cpf) throws Exception {
        pessoaService.delete(pessoaService.getByCPF(cpf).getIdPessoa());
        return dadosPessoaisClient.delete(cpf);
    }

}
