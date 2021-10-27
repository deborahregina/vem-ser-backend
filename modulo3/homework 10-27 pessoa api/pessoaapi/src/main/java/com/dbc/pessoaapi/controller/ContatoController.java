package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.ContatoService;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private ContatoService contatoService;

    public ContatoController() {
       contatoService = new ContatoService();
    }

    @PostMapping("/{idPessoa}")
    public Contato create(@RequestBody Contato contato,@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.create(contato, idPessoa);
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return contatoService.listByPessoa(idPessoa);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer idContato,
                         @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(idContato, contatoAtualizar);
    }
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}
