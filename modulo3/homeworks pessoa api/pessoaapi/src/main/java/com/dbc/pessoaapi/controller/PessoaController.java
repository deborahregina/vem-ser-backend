package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.PessoaService;
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
@RequestMapping("/pessoa")
@Validated
@Slf4j
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @ApiOperation(value = "Cria uma nova pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa criada com sucesso"),
            @ApiResponse(code = 403, message = "Não foi possível criar esse registro"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping
    public PessoaDTO create(@RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        log.info("iniciando criação da pessoa");
        PessoaDTO pessoaEntityCriado = pessoaService.create(pessoaCreateDTO);
        log.info("Pessoa criada com sucesso!");
        return pessoaEntityCriado;
    }
    @ApiOperation(value = "Lista pessoa por ID")
    @GetMapping("/{idPessoa}")
    public PessoaDTO getById(@RequestParam("idPessoa") Integer idPessoa) throws Exception {
        return pessoaService.getById(idPessoa);
    }

    @ApiOperation(value = "Lista todos os registros de pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @ApiOperation(value = "Lista informações da pessoa, passando o nome dela")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna informações da pessoa"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) throws RegraDeNegocioException {
        return pessoaService.listByName(nome);
    }

    @ApiOperation(value = "Altera dados do cadastro da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa alterada com sucesso"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                               @RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        log.info("Iniciando atualização de pessoa");
        PessoaDTO pessoaAtualizada = pessoaService.update(id, pessoaCreateDTO);
        log.info("Pessoa atualizada com sucesso");
        return pessoaAtualizada;
    }

    @ApiOperation(value = "Deleta cadastro de pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa deletada com sucesso"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Deletando pessoa..");
        pessoaService.delete(id);
        log.info("Pessoa deletada com sucesso!");
    }
}
