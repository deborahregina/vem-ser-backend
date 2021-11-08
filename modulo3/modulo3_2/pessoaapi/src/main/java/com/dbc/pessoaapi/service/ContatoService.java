package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Slf4j
@RequiredArgsConstructor
@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final ObjectMapper objectMapper;


    public ContatoDTO create(ContatoCreateDTO contatoCreateDTO, Integer idPessoa) throws RegraDeNegocioException {
        ContatoEntity contatoCriado = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        contatoCriado.setIdPessoa(idPessoa);
        contatoRepository.save(contatoCriado);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);
        return contatoDTO;
    }

    public List<ContatoDTO> list(){

        return contatoRepository.findAll().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());

    }

    public ContatoDTO update(Integer idContato,
                                ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {

        findById(idContato);
        ContatoEntity contato = objectMapper.convertValue(contatoCreateDTO,ContatoEntity.class);
        contato.setIdContato(idContato);
        ContatoEntity update = contatoRepository.save(contato);
        ContatoDTO contatoDTO = objectMapper.convertValue(update, ContatoDTO.class);

        return contatoDTO;

    }

    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contato = findById(id);
        contatoRepository.delete(contato);
    }

    private ContatoEntity findById(Integer id) throws RegraDeNegocioException {
        ContatoEntity entity = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return entity;
    }

    public ContatoDTO getById(Integer id) throws RegraDeNegocioException {
        ContatoEntity entity = findById(id);
        ContatoDTO dto = objectMapper.convertValue(entity, ContatoDTO.class);
        return dto;
    }
}