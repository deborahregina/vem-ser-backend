package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.service.ContatoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
@Slf4j
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") Integer idPessoa,
                             @RequestBody ContatoCreateDTO contatoCreateDTO) throws Exception {
        return contatoService.create(contatoCreateDTO, idPessoa);
    }

    @PutMapping("/{id}")
    public ContatoDTO update(@PathVariable("id") Integer id,
                                @RequestBody ContatoCreateDTO contatoCreateDTO) throws Exception {
        return contatoService.update(id, contatoCreateDTO);
    }

    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }


    // {{url}}/contato/1/contato
    @GetMapping("/{idContato}/contato")
    public ContatoDTO listByIdContato(@PathVariable("idContato") Integer idContato) throws Exception {
        return contatoService.getById(idContato);
    }

}