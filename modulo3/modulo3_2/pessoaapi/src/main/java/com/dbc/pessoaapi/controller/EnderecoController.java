package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.EnderecoService;
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
@RequestMapping("/endereco")
@Validated
@Slf4j
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @ApiOperation(value = "Cria uma novo endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço cadastrado com sucesso"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping
    public EnderecoDTO create(@RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        EnderecoDTO enderecoCriado = enderecoService.create(enderecoCreateDTO);
        return enderecoCriado;
    }

    @ApiOperation(value = "Lista todos os endereços cadastrados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listagem de endereços"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @ApiOperation(value = "Lista endereço por ID do endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço encontrado"),
            @ApiResponse(code = 400, message = "Endereço não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idEndereco}")
    public EnderecoDTO listByPessoa(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
       return enderecoService.getById(idEndereco);
    }


    @ApiOperation(value = "Altera informações de um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço alterado com sucesso"),
            @ApiResponse(code = 400, message = "Endereço não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{id}")
    public EnderecoDTO update(@PathVariable("id") Integer id,
                                 @RequestBody @Valid EnderecoCreateDTO endereco) throws Exception {
        log.info("Atualizando endereço...");
        EnderecoDTO enderecoAtualizado = enderecoService.update(id,endereco);
        log.info("Endereco atualizado com sucesso!");
        return enderecoAtualizado;
    }

    @ApiOperation(value = "Deleta endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço deletado com sucesso"),
            @ApiResponse(code = 400, message = "Endereço não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        log.info("Deletando endereço...");
        enderecoService.delete(id);
        log.info("Endereco deletado com sucesso!");
    }
}
