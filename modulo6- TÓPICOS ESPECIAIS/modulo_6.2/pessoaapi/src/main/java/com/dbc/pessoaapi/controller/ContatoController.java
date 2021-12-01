package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
@Slf4j
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;
    private final ContatoRepository contatoRepository;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @PostMapping("/{idPessoa}")
    public ContatoDTO create( @PathVariable("idPessoa") Integer idPessoa, @RequestBody ContatoCreateDTO contatoCreateDTO) throws Exception {
        return contatoService.create(idPessoa, contatoCreateDTO);
    }

    @PutMapping("/{id}")
    public ContatoDTO update(@PathVariable("id") Integer id,
                                @RequestBody ContatoCreateDTO contatoCreateDTO) throws Exception {
        return contatoService.update(id, contatoCreateDTO);
    }

    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }


    // {{url}}/contato/1/contato
    @ApiOperation(value = "Lista contatos id contato")
    @GetMapping("/{idContato}/contato")
    public ContatoDTO listByIdContato(@PathVariable("idContato") Integer idContato) throws Exception {
        return contatoService.getById(idContato);
    }

    @ApiOperation(value = "Lista contatos por tipo contato")
    @GetMapping("/tipoContato")
    List<ContatoEntity> procuraPorTipoContato(@RequestParam("tipoContato") TipoContato tipoContato) {
        return contatoRepository.procuraPorTipoContato(tipoContato);
    }

    @ApiOperation(value = "Lista contatos por Id pessoa")
    @GetMapping("/{idPessoa}")
    List<ContatoEntity> findContatoPorIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoRepository.findContatoPorIdPessoa(idPessoa);
    }
}