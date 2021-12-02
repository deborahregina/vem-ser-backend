package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
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
    private final PessoaRepository pessoaRepository;



    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        PessoaEntity pessoa = pessoaRepository.getById(idPessoa);
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        contatoEntity.setPessoaEntity(pessoa);
        ContatoEntity contatoCriado = contatoRepository.save(contatoEntity);
        return objectMapper.convertValue(contatoCriado, ContatoDTO.class);
    }

    public List<ContatoDTO> list(){

        return contatoRepository.findAll().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());

    }

    public ContatoDTO update(Integer idContato, ContatoCreateDTO contatoCreateDTOAtualizar) throws RegraDeNegocioException{
        findById(idContato);
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTOAtualizar, ContatoEntity.class);
        contatoEntity.setIdContato(idContato);
        ContatoEntity contatoEntityAtualizar = contatoRepository.save(contatoEntity);
        return objectMapper.convertValue(contatoEntityAtualizar, ContatoDTO.class);
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