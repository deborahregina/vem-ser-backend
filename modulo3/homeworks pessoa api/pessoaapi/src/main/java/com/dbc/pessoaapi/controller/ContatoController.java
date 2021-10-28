package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.ContatoService;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping("/{idPessoa}")
    public Contato create(@RequestBody @Valid Contato contato, @PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return contatoService.create(contato, idPessoa);
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return contatoService.listByPessoa(idPessoa);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer idContato,
                         @RequestBody @Valid Contato contatoAtualizar) throws RegraDeNegocioException {
        return contatoService.update(idContato, contatoAtualizar);
    }
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }
}
