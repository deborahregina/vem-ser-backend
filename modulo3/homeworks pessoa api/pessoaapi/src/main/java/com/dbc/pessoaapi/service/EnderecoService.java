package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;

    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO, Integer idPessoa) throws RegraDeNegocioException {

        List<EnderecoEntity> listaEnderecosPessoa = enderecoRepository.listByIdPessoa(idPessoa);
        if (listaEnderecosPessoa.isEmpty()) {
            throw new RegraDeNegocioException("Pessoa não encontrada!");
        }

        enderecoCreateDTO.setIdPessoa(idPessoa);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity enderecoCriado = enderecoRepository.create(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_INDEX);
        return enderecoDTO;
    }

    public List<EnderecoDTO> list(){
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO listaEnd(Integer idEndereco) throws Exception {

       EnderecoEntity endereco = enderecoRepository.listaEnd(idEndereco);
       EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco,EnderecoDTO.class);

       return enderecoDTO;

    }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {

        return enderecoRepository.listByIdPessoa(idPessoa).stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());

    }

    public EnderecoDTO update(Integer idEndereco,
                                 EnderecoCreateDTO enderecoAtualizar) throws Exception {

        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoAtualizar, EnderecoEntity.class);
        EnderecoEntity enderecoCriado = enderecoRepository.update(idEndereco,enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);

        return enderecoDTO;

    }

    public void delete(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }
}
