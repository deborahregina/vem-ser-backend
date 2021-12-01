package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.*;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EnderecoRepository {

    private static List<EnderecoEntity> listaEnderecos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    @Autowired
    private final PessoaService pessoaService;



    public EnderecoEntity create(EnderecoEntity endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());

        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<EnderecoEntity> list() {
        return listaEnderecos;
    }

    public EnderecoEntity listaEnd(Integer idEndereco) throws RegraDeNegocioException {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco)).findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não econtrado"));
    }

    public List<EnderecoEntity> listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {

        pessoaService.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa)).findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return listaEnderecos.stream().filter(endereco -> endereco.getIdPessoa().equals(idPessoa)).collect(Collectors.toList());
    }

    public EnderecoEntity update(Integer idEndereco,
                                 EnderecoEntity enderecoAtualizar) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não econtrado"));
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        EnderecoEntity enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não econtrado"));
        listaEnderecos.remove(enderecoRecuperado);
    }
}
