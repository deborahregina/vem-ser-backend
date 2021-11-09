package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.pk.ProfessorPk;
import com.dbc.pessoaapi.repository.ProfessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ObjectMapper objectMapper;

    public ProfessorDTO create(ProfessorCreateDTO professorCreateDTO) throws Exception {

        ProfessorEntity professor = objectMapper.convertValue(professorCreateDTO, ProfessorEntity.class);
        professor.setProfessorPk(objectMapper.convertValue(professorCreateDTO.getProfessorPkDTO(),ProfessorPk.class));
        professorRepository.save(professor);
        ProfessorDTO professorDTO = objectMapper.convertValue(professor, ProfessorDTO.class);
        professorDTO.setProfessorPkDTO(objectMapper.convertValue(professor.getProfessorPk(),ProfessorPkDTO.class));
        return professorDTO;
    }

    public List<ProfessorDTO> list(){
        List<ProfessorEntity> listaProfs = professorRepository.findAll();
        List<ProfessorDTO> listaProfsDto = new ArrayList<>();

        for(ProfessorEntity profs: listaProfs) {

            ProfessorDTO professorConv = objectMapper.convertValue(profs,ProfessorDTO.class);
            professorConv.setProfessorPkDTO(objectMapper.convertValue(profs.getProfessorPk(),ProfessorPkDTO.class));
            listaProfsDto.add(professorConv);

        }


        return listaProfsDto;
    }

    public ProfessorDTO update(ProfessorCreateDTO professorCreateDTO) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        findById(professorCreateDTO.getProfessorPkDTO());
        ProfessorEntity professor = objectMapper.convertValue(professorCreateDTO,ProfessorEntity.class);
        professor.setProfessorPk(objectMapper.convertValue(professorCreateDTO.getProfessorPkDTO(),ProfessorPk.class));
        ProfessorEntity update = professorRepository.save(professor);
        ProfessorDTO professorDTO = objectMapper.convertValue(update, ProfessorDTO.class);
        professorDTO.setProfessorPkDTO(objectMapper.convertValue(update.getProfessorPk(),ProfessorPkDTO.class));
        return professorDTO;
    }

    private ProfessorEntity findById(ProfessorPkDTO id) throws RegraDeNegocioException {
        ProfessorPk professorPk = objectMapper.convertValue(id, ProfessorPk.class);
        ProfessorEntity entity = professorRepository.findById(professorPk)
                .orElseThrow(() -> new RegraDeNegocioException("Professor não encontrado"));
        return entity;
    }

    public ProfessorDTO getById(Integer idProfessor, Integer idUniversidade) throws RegraDeNegocioException {
        ProfessorPkDTO profChave = new ProfessorPkDTO(idProfessor,idUniversidade);
        ProfessorEntity entity = findById(profChave);
        ProfessorDTO dto = objectMapper.convertValue(entity, ProfessorDTO.class);
        dto.setProfessorPkDTO(profChave);
        return dto;
    }


    public void delete(ProfessorPkDTO id) throws Exception {
        ProfessorEntity professor = findById(id);
        professorRepository.delete(professor);
    }
}
