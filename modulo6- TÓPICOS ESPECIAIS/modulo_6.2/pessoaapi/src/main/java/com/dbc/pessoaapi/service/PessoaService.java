package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws Exception {

        PessoaEntity pessoaCriada = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        pessoaRepository.save(pessoaCriada);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        findById(id);
        PessoaEntity pessoa = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        pessoa.setIdPessoa(id);
        PessoaEntity update = pessoaRepository.save(pessoa);
        PessoaDTO pessoaDTO = objectMapper.convertValue(update, PessoaDTO.class);
        return pessoaDTO;
    }


    public void delete(Integer id) throws Exception {

        PessoaEntity pessoa = findById(id);
        pessoaRepository.delete(pessoa);
    }

    private PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("pessoa não encontrada"));
        return entity;
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = findById(id);
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        return dto;
    }

    public List<PessoaComEnderecoDTO> ListaComEndereco() {

        List<PessoaEntity> listaPessoaComp = pessoaRepository.findAll();

        List<PessoaComEnderecoDTO> listaPessoaComEnd = new ArrayList<>();

        for(PessoaEntity pessoa: listaPessoaComp) {

            PessoaComEnderecoDTO pessoaConv = objectMapper.convertValue(pessoa,PessoaComEnderecoDTO.class);

            pessoaConv.setEnderecos(pessoa.getEnderecos().stream().
                    map(enderecoEntity -> {
                       EnderecoDTO enderecoDTO =  objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                        enderecoDTO.setIdPessoa(pessoa.getIdPessoa());
                        return enderecoDTO;
                    }).collect(Collectors.toSet()));

            listaPessoaComEnd.add(pessoaConv);
        }

        return listaPessoaComEnd;
    }

    public List<PessoaComContatoDTO> listaComContato() {

        List<PessoaEntity> listaPessoaComp = pessoaRepository.findAll();

        List<PessoaComContatoDTO> listaPessoaComContato = new ArrayList<>();

        for(PessoaEntity pessoa: listaPessoaComp) {

            PessoaComContatoDTO pessoaConv = objectMapper.convertValue(pessoa,PessoaComContatoDTO.class);
            pessoaConv.setContatos(pessoa.getContatos().stream().
                    map(contatoEntity -> {

                        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
                        contatoDTO.setIdPessoa(pessoa.getIdPessoa());
                        return contatoDTO;

                    }).collect(Collectors.toSet()));

            listaPessoaComContato.add(pessoaConv);
        }

        return listaPessoaComContato;
    }

    public List<PessoaComEnderecoDTO> listaPessoaComEnderecoId(Integer idPessoa) throws RegraDeNegocioException {

        List<PessoaEntity> listaPessoaComp = pessoaRepository.findAll();
        List<PessoaComEnderecoDTO> listaPessoaComEnd = new ArrayList<>();

        if (idPessoa == null) {
            for(PessoaEntity pessoa: listaPessoaComp) {

                PessoaComEnderecoDTO pessoaConv = objectMapper.convertValue(pessoa,PessoaComEnderecoDTO.class);

                pessoaConv.setEnderecos(pessoa.getEnderecos().stream().
                        map(enderecoEntity -> {
                            EnderecoDTO enderecoDTO =  objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                            enderecoDTO.setIdPessoa(pessoa.getIdPessoa());
                            return enderecoDTO;
                        }).collect(Collectors.toSet()));

                listaPessoaComEnd.add(pessoaConv);
            }

            return listaPessoaComEnd;
        }

        PessoaEntity pessoaProdurada = findById(idPessoa);

        PessoaComEnderecoDTO pessoaComEnderecoDTO = objectMapper.convertValue(pessoaProdurada, PessoaComEnderecoDTO.class);
        pessoaComEnderecoDTO.setEnderecos(pessoaProdurada.getEnderecos().stream().
                map(enderecoEntity ->  {
                    EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                    enderecoDTO.setIdPessoa(idPessoa);
                    return enderecoDTO;
                }).collect(Collectors.toSet()));


        listaPessoaComEnd.add(pessoaComEnderecoDTO);
        return listaPessoaComEnd;

    }

    public List<PessoaComContatoDTO> listaPessoaComContatooId(Integer idPessoa) throws RegraDeNegocioException {

        List<PessoaEntity> listaPessoaComp = pessoaRepository.findAll();
        List<PessoaComContatoDTO> listaPessoaComContato = new ArrayList<>();

        if(idPessoa == null) {
            for(PessoaEntity pessoa: listaPessoaComp) {

                PessoaComContatoDTO pessoaConv = objectMapper.convertValue(pessoa,PessoaComContatoDTO.class);
                pessoaConv.setContatos(pessoa.getContatos().stream().
                        map(contatoEntity -> {

                            ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
                            contatoDTO.setIdPessoa(pessoa.getIdPessoa());
                            return contatoDTO;

                        }).collect(Collectors.toSet()));

                listaPessoaComContato.add(pessoaConv);
            }

            return listaPessoaComContato;
        }

        PessoaEntity pessoaProdurada = findById(idPessoa);

        PessoaComContatoDTO pessoaComContatoDTO = objectMapper.convertValue(pessoaProdurada, PessoaComContatoDTO.class);
        pessoaComContatoDTO.setContatos(pessoaProdurada.getContatos().stream().
                map(contatoEntity -> {

                    ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
                    contatoDTO.setIdPessoa(idPessoa);
                    return contatoDTO;

                }).collect(Collectors.toSet()));


        listaPessoaComContato.add(pessoaComContatoDTO);
        return listaPessoaComContato;

    }

    public List<PessoaComTodosDadosDTO> listaPessoaCompleta(Integer idPessoa) throws RegraDeNegocioException {

        List<PessoaEntity> listaPessoasEntity = pessoaRepository.findAll();
        List<PessoaComTodosDadosDTO> listaPessoaComDados = new ArrayList<>();

        if (idPessoa == null) {

            for(PessoaEntity pessoa: listaPessoasEntity) {

                PessoaComTodosDadosDTO pessoaConv = objectMapper.convertValue(pessoa,PessoaComTodosDadosDTO.class);
                pessoaConv.setContatos(pessoa.getContatos().stream().
                        map(contatoEntity -> {

                            ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
                            contatoDTO.setIdPessoa(pessoa.getIdPessoa());
                            return contatoDTO;

                        }).collect(Collectors.toSet()));

                pessoaConv.setEnderecos(pessoa.getEnderecos().stream().
                        map(enderecoEntity -> {

                            EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                            enderecoDTO.setIdPessoa(pessoa.getIdPessoa());
                            return enderecoDTO;

                        }).collect(Collectors.toSet()));

                listaPessoaComDados.add(pessoaConv);
            }
            return listaPessoaComDados;
        }
        PessoaEntity pessoaProdurada = findById(idPessoa);

        PessoaComTodosDadosDTO pessoaComTodosDadosDTO = objectMapper.convertValue(pessoaProdurada, PessoaComTodosDadosDTO.class);
        pessoaComTodosDadosDTO.setContatos(pessoaProdurada.getContatos().stream().
                map(contatoEntity -> {

                    ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
                    contatoDTO.setIdPessoa(idPessoa);
                    return contatoDTO;

                }).collect(Collectors.toSet()));

        pessoaComTodosDadosDTO.setEnderecos(pessoaProdurada.getEnderecos().stream().
                map(enderecoEntity -> {

                    EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                    enderecoDTO.setIdPessoa(idPessoa);
                    return enderecoDTO;

                }).collect(Collectors.toSet()));

        listaPessoaComDados.add(pessoaComTodosDadosDTO);
        return listaPessoaComDados;

    }
}
