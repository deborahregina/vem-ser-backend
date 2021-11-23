package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.pk.ProfessorPk;
import com.dbc.pessoaapi.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/professor")
@Validated
@Slf4j
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ProfessorDTO create(@RequestBody @Valid ProfessorCreateDTO professorCreateDTO) throws Exception {
        ProfessorDTO professorDTO = professorService.create(professorCreateDTO);
        return professorDTO;
    }

    @GetMapping("/find-by-id")
    public ProfessorDTO getById(@RequestParam Integer idProfessor, @RequestParam Integer idUniversidade) throws Exception {
        return professorService.getById(idProfessor,idUniversidade);
    }

    @GetMapping
    public List<ProfessorDTO> list() {
        return professorService.list();
    }

    @PutMapping("/idProfessor")
    public ProfessorDTO update(@RequestBody @Valid ProfessorCreateDTO professorCreateDTO) throws Exception {

        ProfessorDTO professor = professorService.update(professorCreateDTO);
        return professor;
    }

    @DeleteMapping("/idProfessor")
    public void delete(@RequestBody ProfessorPkDTO id) throws Exception {
        professorService.delete(id);
    }

}
