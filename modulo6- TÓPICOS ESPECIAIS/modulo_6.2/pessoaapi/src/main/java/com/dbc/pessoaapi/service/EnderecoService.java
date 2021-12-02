package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;
    private final PessoaRepository pessoaRepository;

    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        pessoaRepository.getById(enderecoCreateDTO.getIdPessoa());
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity enderecoCriado = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
        enderecoDTO.setIdPessoa(enderecoCreateDTO.getIdPessoa());
        return enderecoDTO;
    }

    public List<EnderecoDTO> list(){
        return enderecoRepository.findAll().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }


    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        pessoaRepository.getById(enderecoCreateDTO.getIdPessoa());
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        enderecoEntity.setIdEndereco(idEndereco);
        EnderecoEntity enderecoAtualizar = enderecoRepository.save(enderecoEntity);
        return objectMapper.convertValue(enderecoAtualizar, EnderecoDTO.class);
    }


    public void delete(Integer id) throws Exception {
        EnderecoEntity endereco = findById(id);
        enderecoRepository.delete(endereco);
    }

    private EnderecoEntity findById(Integer id) throws RegraDeNegocioException {
        EnderecoEntity entity = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return entity;
    }

    public EnderecoDTO getById(Integer id) throws RegraDeNegocioException {
        EnderecoEntity entity = findById(id);
        EnderecoDTO dto = objectMapper.convertValue(entity, EnderecoDTO.class);
        return dto;
    }
}
