package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.EnderecoService;
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

    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO, @PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        log.info("Criando endereço...");
        EnderecoDTO enderecoCriado = enderecoService.create(enderecoCreateDTO,idPessoa);
        log.info("Endereco criado com sucesso!");
        return enderecoCriado;
    }

    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public EnderecoDTO listByPessoa(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
       return enderecoService.listaEnd(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PutMapping("/{id}")
    public EnderecoDTO update(@PathVariable("id") Integer id,
                                 @RequestBody @Valid EnderecoCreateDTO endereco) throws Exception {
        log.info("Atualizando endereço...");
        EnderecoDTO enderecoAtualizado = enderecoService.update(id,endereco);
        log.info("Endereco atualizado com sucesso!");
        return enderecoAtualizado;
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        log.info("Deletando endereço...");
        enderecoService.delete(id);
        log.info("Endereco deletado com sucesso!");
    }
}
