package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.service.DadosPessoaisService;
import com.dbc.pessoaapi.service.PessoaService;
import com.dbc.pessoaapi.service.PessoasDadosPessoaisService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@RequestMapping("/PessoaDadosPessoais")
@Validated
@Slf4j
@RequiredArgsConstructor
public class PessoaDadosPessoaisController {

    private final DadosPessoaisService dadosPessoaisService;
    private final PessoaService pessoaService;
    private final PessoasDadosPessoaisService pessoasDadosPessoaisService;
    private final ObjectMapper objectMapper;

    @ApiOperation(value = "Cria uma nova pessoa com seus dados pessoais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa criada com sucesso"),
            @ApiResponse(code = 403, message = "Não foi possível criar esse registro"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping
    public PessoaDadosPessoaisDTO create(@RequestBody @Valid PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {

        DadosPessoaisDTO dadosPessoaisNovoDTO = objectMapper.convertValue(pessoaDadosPessoaisDTO,DadosPessoaisDTO.class);
        PessoaCreateDTO pessoaCreateDTO = objectMapper.convertValue(pessoaDadosPessoaisDTO,PessoaCreateDTO.class);

        pessoasDadosPessoaisService.create(pessoaCreateDTO, dadosPessoaisNovoDTO, pessoaDadosPessoaisDTO);
        return pessoaDadosPessoaisDTO;

    }

    @ApiOperation(value = "Lista pessoa e dados pessoais")
    @GetMapping
    public List<PessoaDadosPessoaisDTO> list() {
        return pessoasDadosPessoaisService.list();
    }

    @PutMapping("/{cpf}")
    public PessoaDadosPessoaisDTO update(@PathVariable("cpf") String cpf,
                            @RequestBody @Valid PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {

        PessoaDadosPessoaisDTO pessoaDadosPessoaisDTOCriado = pessoasDadosPessoaisService.update(pessoaDadosPessoaisDTO);
        return pessoaDadosPessoaisDTOCriado;
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) throws Exception {
        pessoasDadosPessoaisService.delete(cpf);
    }

}
