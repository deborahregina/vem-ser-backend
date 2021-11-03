package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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


    @ApiOperation(value = "Cria um novo contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contato criado com sucesso"),
            @ApiResponse(code = 400, message = "Informações incorretas"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@RequestBody @Valid ContatoCreateDTO contatoCreateDTO, @PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        log.info("Iniciando criação de contato");
        ContatoDTO contatoEntityCriado = contatoService.create(contatoCreateDTO,idPessoa);
        log.info("Contato criado com sucesso");
        return contatoEntityCriado;
    }


    @ApiOperation(value = "Lista todos os contatos de uma pessoa por ID da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de contatos da pessoa"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return contatoService.listByPessoa(idPessoa);
    }

    @ApiOperation(value = "Lista todos os contatos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de contatos"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @ApiOperation(value = "Altera informações de um contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contato alterado com sucesso"),
            @ApiResponse(code = 400, message = "Contato não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") Integer idContato,
                                @RequestBody @Valid ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        log.info("Iniciando atualizacao de contato");
        ContatoDTO contatoAtualizado = contatoService.update(idContato,contatoAtualizar);
        log.info("Contato atualizado com sucesso");
        return contatoAtualizado;
    }

    @ApiOperation(value = "Deleta contato por ID contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contato deletado com sucesso"),
            @ApiResponse(code = 400, message = "Contato não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        log.info("Deletando contato...");
        contatoService.delete(id);
        log.info("Contato deletado com sucesso!");
    }
}
