package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{idPessoa}")
    public Endereco create(@RequestBody @Valid Endereco endereco, @PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return enderecoService.create(endereco, idPessoa);
    }

    @GetMapping
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public Endereco listByPessoa(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return enderecoService.listaEnd(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PutMapping("/{id}")
    public Endereco update(@PathVariable("id") Integer id,
                          @RequestBody @Valid Endereco endereco) throws Exception {
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
