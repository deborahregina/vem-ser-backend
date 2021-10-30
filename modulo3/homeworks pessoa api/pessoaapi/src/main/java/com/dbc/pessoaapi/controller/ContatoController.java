package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.ContatoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
@Slf4j
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;


    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@RequestBody @Valid ContatoCreateDTO contatoCreateDTO, @PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        log.info("Iniciando criação de contato");
        ContatoDTO contatoEntityCriado = contatoService.create(contatoCreateDTO,idPessoa);
        log.info("Contato criado com sucesso");
        return contatoEntityCriado;
    }

    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return contatoService.listByPessoa(idPessoa);
    }

    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") Integer idContato,
                                @RequestBody @Valid ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        log.info("Iniciando atualizacao de contato");
        ContatoDTO contatoAtualizado = contatoService.update(idContato,contatoAtualizar);
        log.info("Contato atualizado com sucesso");
        return contatoAtualizado;
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        log.info("Deletando contato...");
        contatoService.delete(id);
        log.info("Contato deletado com sucesso!");
    }
}
