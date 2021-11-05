package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.dto.PessoaDadosPessoaisDTO;
import com.dbc.pessoaapi.entity.PessoaDadosPessoaisEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaDadosPessoaisRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PessoasDadosPessoaisService {

    private final DadosPessoaisService dadosPessoaisService;
    private final PessoaService pessoaService;
    private final PessoaDadosPessoaisRepository pessoaDadosPessoaisRepository;
    private final ObjectMapper objectMapper;

    public PessoaDadosPessoaisDTO create(PessoaCreateDTO pessoaCreateDTO, DadosPessoaisDTO dadosPessoaisDTO, PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {

        pessoaCreateDTO.setDadosPessoaisDTO(dadosPessoaisDTO);
        dadosPessoaisService.create(dadosPessoaisDTO);
        pessoaService.create(pessoaCreateDTO);
        PessoaDadosPessoaisEntity entity = objectMapper.convertValue(pessoaDadosPessoaisDTO, PessoaDadosPessoaisEntity.class);
        pessoaDadosPessoaisRepository.create(entity);

        return pessoaDadosPessoaisDTO;
    }

    public List<PessoaDadosPessoaisDTO> list() {

        return pessoaDadosPessoaisRepository.list().stream()
                .map(pessoaDados -> objectMapper.convertValue(pessoaDados, PessoaDadosPessoaisDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDadosPessoaisDTO update(String cpf, PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws MessagingException, TemplateException, RegraDeNegocioException, IOException {

        DadosPessoaisDTO dadosPessoaisNovoDTO = objectMapper.convertValue(pessoaDadosPessoaisDTO, DadosPessoaisDTO.class);
        PessoaCreateDTO pessoaCreateDTO = objectMapper.convertValue(pessoaDadosPessoaisDTO, PessoaCreateDTO.class);

        pessoaService.update(cpf, pessoaCreateDTO);
        dadosPessoaisService.update(cpf, dadosPessoaisNovoDTO);
        PessoaDadosPessoaisEntity pessoaEntity = objectMapper.convertValue(pessoaDadosPessoaisDTO, PessoaDadosPessoaisEntity.class);
        PessoaDadosPessoaisDTO pessoaDadosDTO = objectMapper.convertValue(pessoaEntity, PessoaDadosPessoaisDTO.class);
        return pessoaDadosDTO;
    }

    public void delete (String cpf) throws Exception {

        dadosPessoaisService.delete(cpf);
        pessoaService.delete(cpf);
        pessoaDadosPessoaisRepository.delete(cpf);

    }

}
