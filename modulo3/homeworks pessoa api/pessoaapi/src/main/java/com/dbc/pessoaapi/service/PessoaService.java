package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    @Autowired
    private EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws Exception {
        if(StringUtils.isBlank(pessoaCreateDTO.getNome())) {
            throw new RegraDeNegocioException("Nome não informado");
        }
        if (ObjectUtils.isEmpty(pessoaCreateDTO.getDataNascimento())) {
            throw new RegraDeNegocioException("Data de nascimento não informado");
        }
        if (StringUtils.isBlank(pessoaCreateDTO.getCpf()) || pessoaCreateDTO.getCpf().length() != 11) {
            throw new RegraDeNegocioException("CPF inválido");
        }

        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        emailService.enviarEmailSaudacoes(pessoaDTO);

        return pessoaDTO;
    }

    public List<PessoaDTO> list(){

        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                               PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {

        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaAtualizada = pessoaRepository.update(id,pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);
        emailService.enviarEmailComTemplateAlteracao(pessoaDTO);
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        PessoaEntity pessoaEntity = pessoaRepository.getById(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        pessoaRepository.delete(id);
        emailService.enviarEmailComTemplateDelete(pessoaDTO);
    }

    public List<PessoaDTO> listByName(String nome) {

        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());

    }
}
