package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;

    @ApiOperation(value = "Cria uma nova pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa criada com sucesso"),
            @ApiResponse(code = 403, message = "Não foi possível criar esse registro"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping
    public PessoaDTO create(@RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        PessoaDTO pessoaEntityCriado = pessoaService.create(pessoaCreateDTO);
        return pessoaEntityCriado;
    }

    @ApiOperation(value = "Lista pessoa e dados pessoais por ID")
    @GetMapping("/{idPessoa}")
    public PessoaDTO getById(@RequestParam("idPessoa") Integer idPessoa) throws Exception {
        return pessoaService.getById(idPessoa);
    }

    @ApiOperation(value = "Lista todos os registros de pessoa e seus dados pessoais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
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
        pessoaService.delete(id);
    }

    @ApiOperation(value = "Lista Pessoa com nome")
    @GetMapping("/nome")
    public List<PessoaEntity> findbyname(@RequestParam("nome") String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @ApiOperation(value = "Lista Pessoa por CPF")
    @GetMapping("/cpf")
    public PessoaEntity findbyCpf(@RequestParam("cpf") String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    @ApiOperation(value = "Lista Pessoas com data de nascimento entre inicio e fim")
    @GetMapping("/find-by-data")
    public List<PessoaEntity> betweenData(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                      LocalDate inicio, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {
            return pessoaRepository.findByDataNascimentoBetween(inicio,fim);
    }

    @ApiOperation(value = "Lista Pessoas com data de nascimento entre inicio e fim com Query")
    @GetMapping("/find-by-data-query")
    public List<PessoaEntity> betweenDataQuery(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                  LocalDate inicio, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {
        return pessoaRepository.findByDataNascimentoBetweenQuery(inicio,fim);
    }

    @ApiOperation(value = "Lista Pessoas com Enderecos por IdPessoa")
    @GetMapping("/find-Pessoa-Endereco-ById")
    public List<PessoaComEnderecoDTO> listaPessoaComEnderecoId(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {

        return pessoaService.listaPessoaComEnderecoId(idPessoa);

    }

    @ApiOperation(value = "Lista Pessoas com contato por IdPessoa")
    @GetMapping("/find-Pessoa-Contato-ById")
    public List<PessoaComContatoDTO> listaPessoasComContatoID(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {

        return pessoaService.listaPessoaComContatooId(idPessoa);

    }

    @ApiOperation(value = "Lista de pessoas com endereço")
    @GetMapping("/find-by-end-not-null")
    public List<PessoaEntity> listaPessoasComEndereco() {
        return pessoaRepository.findByEnderecoIsNotNull();
    }

    @ApiOperation(value = "Lista de pessoas com endereço null (nativo)")
    @GetMapping("/find-pessoas-endereco-null")
    public List<PessoaEntity> findPessoasComEndNull() {
        return pessoaRepository.findPessoasComEndNull();
    }

    @ApiOperation(value = "Lista Pessoa(s) com todos os dados")
    @GetMapping("/lista-pessoa-completa")
    public List<PessoaComTodosDadosDTO> listaPessoaCompleta(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listaPessoaCompleta(idPessoa);

    }


}
